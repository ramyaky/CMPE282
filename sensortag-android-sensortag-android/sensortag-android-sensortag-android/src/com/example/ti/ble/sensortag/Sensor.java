/**************************************************************************************************
  Filename:       Sensor.java
  Revised:        $Date: 2013-08-30 11:44:31 +0200 (fr, 30 aug 2013) $
  Revision:       $Revision: 27454 $

  Copyright (c) 2013 - 2014 Texas Instruments Incorporated

  All rights reserved not granted herein.
  Limited License. 

  Texas Instruments Incorporated grants a world-wide, royalty-free,
  non-exclusive license under copyrights and patents it now or hereafter
  owns or controls to make, have made, use, import, offer to sell and sell ("Utilize")
  this software subject to the terms herein.  With respect to the foregoing patent
  license, such license is granted  solely to the extent that any such patent is necessary
  to Utilize the software alone.  The patent license shall not apply to any combinations which
  include this software, other than combinations with devices manufactured by or for TI (�TI Devices�). 
  No hardware patent is licensed hereunder.

  Redistributions must preserve existing copyright notices and reproduce this license (including the
  above copyright notice and the disclaimer and (if applicable) source code license limitations below)
  in the documentation and/or other materials provided with the distribution

  Redistribution and use in binary form, without modification, are permitted provided that the following
  conditions are met:

    * No reverse engineering, decompilation, or disassembly of this software is permitted with respect to any
      software provided in binary form.
    * any redistribution and use are licensed by TI for use only with TI Devices.
    * Nothing shall obligate TI to provide you with source code for the software licensed and provided to you in object code.

  If software source code is provided to you, modification and redistribution of the source code are permitted
  provided that the following conditions are met:

    * any redistribution and use of the source code, including any resulting derivative works, are licensed by
      TI for use only with TI Devices.
    * any redistribution and use of any object code compiled from the source code and any resulting derivative
      works, are licensed by TI for use only with TI Devices.

  Neither the name of Texas Instruments Incorporated nor the names of its suppliers may be used to endorse or
  promote products derived from this software without specific prior written permission.

  DISCLAIMER.

  THIS SOFTWARE IS PROVIDED BY TI AND TI�S LICENSORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
  BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
  IN NO EVENT SHALL TI AND TI�S LICENSORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
  OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
  OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
  POSSIBILITY OF SUCH DAMAGE.


 **************************************************************************************************/
package com.example.ti.ble.sensortag;

//import static android.bluetooth.BluetoothGattCharacteristic.FORMAT_UINT8;
import static com.example.ti.ble.sensortag.SensorTagGatt.*;
import static java.lang.Math.pow;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.http.cookie.Cookie;
import java.util.Random;
import com.example.ti.util.Point3D;
import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQuery;
import com.parse.ParseException;

import android.app.AlertDialog;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.content.DialogInterface;
import android.app.Activity;



import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
// import android.util.Log;
import android.util.Log;
import android.util.Range;
import android.widget.Toast;


/**
 * This enum encapsulates the differences amongst the sensors. The differences include UUID values and how to interpret the
 * characteristic-containing-measurement.
 */

public enum Sensor {
  IR_TEMPERATURE(UUID_IRT_SERV, UUID_IRT_DATA, UUID_IRT_CONF) {
	
	
	@Override
    public Point3D convert(final byte [] value) {

      /*
       * The IR Temperature sensor produces two measurements; Object ( AKA target or IR) Temperature, and Ambient ( AKA die ) temperature.
       * Both need some conversion, and Object temperature is dependent on Ambient temperature.
       * They are stored as [ObjLSB, ObjMSB, AmbLSB, AmbMSB] (4 bytes) Which means we need to shift the bytes around to get the correct values.
       */

      double ambient = extractAmbientTemperature(value);
     
      double target = extractTargetTemperature(value, ambient);


        try {
            sendtoParse(ambient,target);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return new Point3D(ambient, target, 0);
    }

    private double extractAmbientTemperature(byte [] v) {
      int offset = 2;
      return shortUnsignedAtOffset(v, offset) / 128.0;
    }

    private double extractTargetTemperature(byte [] v, double ambient) {
      Integer twoByteValue = shortSignedAtOffset(v, 0);

      double Vobj2 = twoByteValue.doubleValue();
      Vobj2 *= 0.00000015625;

      double Tdie = ambient + 273.15;

      double S0 = 5.593E-14; // Calibration factor
      double a1 = 1.75E-3;
      double a2 = -1.678E-5;
      double b0 = -2.94E-5;
      double b1 = -5.7E-7;
      double b2 = 4.63E-9;
      double c2 = 13.4;
      double Tref = 298.15;
      double S = S0 * (1 + a1 * (Tdie - Tref) + a2 * pow((Tdie - Tref), 2));
      double Vos = b0 + b1 * (Tdie - Tref) + b2 * pow((Tdie - Tref), 2);
      double fObj = (Vobj2 - Vos) + c2 * pow((Vobj2 - Vos), 2);
      double tObj = pow(pow(Tdie, 4) + (fObj / S), .25);

      return tObj - 273.15;
    }
  },

  ACCELEROMETER(UUID_ACC_SERV, UUID_ACC_DATA, UUID_ACC_CONF,(byte)3) {
  	@Override
  	public Point3D convert(final byte[] value) {
  		/*
  		 * The accelerometer has the range [-2g, 2g] with unit (1/64)g.
  		 * To convert from unit (1/64)g to unit g we divide by 64.
  		 * (g = 9.81 m/s^2)
  		 * The z value is multiplied with -1 to coincide with how we have arbitrarily defined the positive y direction. (illustrated by the apps accelerometer
  		 * image)
  		 */
			DeviceActivity da = DeviceActivity.getInstance();

			if (da.isSensorTag2()) {
  			// Range 8G
  			final float SCALE = (float) 4096.0;
  			
  			int x = (value[0]<<8) + value[1];
  			int y = (value[2]<<8) + value[3];
  			int z = (value[4]<<8) + value[5]; 
  			return new Point3D(x / SCALE, y / SCALE, z / SCALE);
  		} else {
  			Point3D v;
  			Integer x = (int) value[0];
  			Integer y = (int) value[1];
  			Integer z = (int) value[2] * -1;
  			
  			if (da.firmwareRevision().contains("1.5"))
  			{
  				// Range 8G
    			final float SCALE = (float) 64.0;
  				v = new Point3D(x / SCALE, y / SCALE, z / SCALE);
  			} else {
  				// Range 2G
    			final float SCALE = (float) 16.0;
  				v = new Point3D(x / SCALE, y / SCALE, z / SCALE);
  			}
  			return v;
  		}

  	}
  },

  HUMIDITY(UUID_HUM_SERV, UUID_HUM_DATA, UUID_HUM_CONF) {
    @Override
    public Point3D convert(final byte[] value) {
      int a = shortUnsignedAtOffset(value, 2);
      // bits [1..0] are status bits and need to be cleared according
      // to the user guide, but the iOS code doesn't bother. It should
      // have minimal impact.
      a = a - (a % 4);
      hum = (-6f) + 125f * (a / 65535f);
     System.out.println("Actual Humidity: "+ hum);
      //setValues(hum);
       return new Point3D((-6f) + 125f * (a / 65535f), 0, 0);
    }
  },

  MAGNETOMETER(UUID_MAG_SERV, UUID_MAG_DATA, UUID_MAG_CONF) {
    @Override
    public Point3D convert(final byte [] value) {
      Point3D mcal = MagnetometerCalibrationCoefficients.INSTANCE.val;
      // Multiply x and y with -1 so that the values correspond with the image in the app
      float x = shortSignedAtOffset(value, 0) * (2000f / 65536f) * -1;
      float y = shortSignedAtOffset(value, 2) * (2000f / 65536f) * -1;
      float z = shortSignedAtOffset(value, 4) * (2000f / 65536f);
      
			return new Point3D(x - mcal.x, y - mcal.y, z - mcal.z);
    }
  },

  LUXOMETER(UUID_OPT_SERV, UUID_OPT_DATA, UUID_OPT_CONF) {
    @Override
    public Point3D convert(final byte [] value) {
      int mantissa;
      int exponent;
      Integer sfloat= shortUnsignedAtOffset(value, 0);
      
      mantissa = sfloat & 0x0FFF;
      exponent = (sfloat >> 12) & 0xFF;

      double output;
      double magnitude = pow(2.0f, exponent);
      output = (mantissa * magnitude);

			return new Point3D(output / 100.0f, 0, 0);
    }
  },

  GYROSCOPE(UUID_GYR_SERV, UUID_GYR_DATA, UUID_GYR_CONF, (byte)7) {
    @Override
    public Point3D convert(final byte [] value) {

      float y = shortSignedAtOffset(value, 0) * (500f / 65536f) * -1;
      float x = shortSignedAtOffset(value, 2) * (500f / 65536f);
      float z = shortSignedAtOffset(value, 4) * (500f / 65536f);
      
      return new Point3D(x,y,z);      
    }
  },

  BAROMETER(SensorTagGatt.UUID_BAR_SERV, SensorTagGatt.UUID_BAR_DATA, SensorTagGatt.UUID_BAR_CONF) {
    @Override
    public Point3D convert(final byte [] value) {

    	if (DeviceActivity.getInstance().isSensorTag2()) {
        int mantissa;
        int exponent;
        Integer sfloat= shortUnsignedAtOffset(value, 2);
        
        mantissa = sfloat & 0x0FFF;
        exponent = (sfloat >> 12) & 0xFF;

        double output;
        double magnitude = pow(2.0f, exponent);
        output = (mantissa * magnitude);

  			return new Point3D(output / 100.0f, 0, 0);
    	} else {
    		List<Integer> barometerCalibrationCoefficients = BarometerCalibrationCoefficients.INSTANCE.barometerCalibrationCoefficients;
    		if (barometerCalibrationCoefficients == null) {
    			// Log.w("Sensor", "Data notification arrived for barometer before it was calibrated.");
    			return new Point3D(0,0,0);
    		}

    		final int[] c; // Calibration coefficients
    		final Integer t_r; // Temperature raw value from sensor
    		final Integer p_r; // Pressure raw value from sensor
    		final Double S; // Interim value in calculation
    		final Double O; // Interim value in calculation
    		final Double p_a; // Pressure actual value in unit Pascal.

    		c = new int[barometerCalibrationCoefficients.size()];
    		for (int i = 0; i < barometerCalibrationCoefficients.size(); i++) {
    			c[i] = barometerCalibrationCoefficients.get(i);
    		}

    		t_r = shortSignedAtOffset(value, 0);
    		p_r = shortUnsignedAtOffset(value, 2);

    		S = c[2] + c[3] * t_r / pow(2, 17) + ((c[4] * t_r / pow(2, 15)) * t_r) / pow(2, 19);
    		O = c[5] * pow(2, 14) + c[6] * t_r / pow(2, 3) + ((c[7] * t_r / pow(2, 15)) * t_r) / pow(2, 4);
    		p_a = (S * p_r + O) / pow(2, 14);

    		return new Point3D(p_a,0,0);
    	}
    }
  },

  SIMPLE_KEYS(UUID_KEY_SERV, UUID_KEY_DATA, null) {
    @Override
    public SimpleKeysStatus convertKeys(final byte value) {
  		/* Key mapping for SensorTagGatt:
  		 * 0 - right key
  		 * 1 - left key
  		 * 2 - side key
  		 */
      int keys = (int) value;
    	if (DeviceActivity.getInstance().isSensorTag2()) {
    		/* Key mapping for SensorTagGatt 2:
    		 * 0 - left key
    		 * 1 - right key
    		 * 2 - reed relay
    		 */
    		int t = keys;
    		keys = t & 0x04;
    		// Swapped keys compared to first SensorTagGatt
    		if ( (t & 1) == 1)
    			keys |= 2;
    		if ( (t & 2) == 2 )
    			keys |= 1;
    	}

      return SimpleKeysStatus.values()[keys & 7];
    }
  };

  /**
   * Gyroscope, Magnetometer, Barometer, IR temperature all store 16 bit two's complement values as LSB MSB, which cannot be directly parsed
   * as getIntValue(FORMAT_SINT16, offset) because the bytes are stored as little-endian.
   * 
   * This function extracts these 16 bit two's complement values.
   * */
  public static double hum;
  public static boolean flag = false;
  private static Integer shortSignedAtOffset(byte[] c, int offset) {
    Integer lowerByte = (int) c[offset] & 0xFF; 
    Integer upperByte = (int) c[offset+1]; // // Interpret MSB as signed
    return (upperByte << 8) + lowerByte;
  }

  private static Integer shortUnsignedAtOffset(byte[] c, int offset) {
    Integer lowerByte = (int) c[offset] & 0xFF; 
    Integer upperByte = (int) c[offset+1] & 0xFF; // // Interpret MSB as signed
    return (upperByte << 8) + lowerByte;
  }

  public void onCharacteristicChanged(BluetoothGattCharacteristic c) {
    throw new UnsupportedOperationException("Error: the individual enum classes are supposed to override this method.");
  }

  public SimpleKeysStatus convertKeys(byte value) {
    throw new UnsupportedOperationException("Error: the individual enum classes are supposed to override this method.");
  }

  public Point3D convert(byte[] value) {
    throw new UnsupportedOperationException("Error: the individual enum classes are supposed to override this method.");
  }

	private final UUID service, data, config;
	private byte enableCode; // See getEnableSensorCode for explanation.
	public static final byte DISABLE_SENSOR_CODE = 0;
	public static final byte ENABLE_SENSOR_CODE = 1;
	public static final byte CALIBRATE_SENSOR_CODE = 2;

	/**
	 * Constructor called by the Gyroscope and Accelerometer because it more than a boolean enable
	 * code.
	 */
  private Sensor(UUID service, UUID data, UUID config, byte enableCode) {
    this.service = service;
    this.data = data;
    this.config = config;
    this.enableCode = enableCode;
  }

  /**
   * Constructor called by all the sensors except Gyroscope
   * */
  private Sensor(UUID service, UUID data, UUID config) {
    this.service = service;
    this.data = data;
    this.config = config;
    this.enableCode = ENABLE_SENSOR_CODE; // This is the sensor enable code for all sensors except the gyroscope
  }

  /**
   * @return the code which, when written to the configuration characteristic, turns on the sensor.
   * */
  public byte getEnableSensorCode() {
    return enableCode;
  }

  public UUID getService() {
    return service;
  }

  public UUID getData() {
    return data;
  }

  public UUID getConfig() {
    return config;
  }

  public static Sensor getFromDataUuid(UUID uuid) {
    for (Sensor s : Sensor.values()) {
      if (s.getData().equals(uuid)) {
        return s;
      }
    }
    throw new RuntimeException("unable to find UUID.");
  }
  
  public static final Sensor[] SENSOR_LIST = {IR_TEMPERATURE, HUMIDITY, BAROMETER};

 public static ArrayList<ParseObject> sickChance = new ArrayList<ParseObject>();
 public static ArrayList<ParseObject> sickChanceNew = new ArrayList<ParseObject>();
 public static int chanceOfSick=0;
 public static int sick=0;
 public static double slope=0;
 public static double intercept=0;
 public static double range=0;
 public Sensor sendtoParse(double ambient, double target) throws ParseException {

        // double range=1.8;
         int cowID=1;
         ParseObject mytestObject = new ParseObject("MyTestObject");
         updateAnalysis();
         chanceOfSickness();
         System.out.println("Previous chance Of Sick*******************"+chanceOfSick);
         double ambientTemp= celsiusToFahrenheit(ambient);
         double bodyTemp= celsiusToFahrenheit(target);
         //ambientTemp= 80.295678;
         //hum= 40.23156;
         //
         //bodyTemp= 133.30312348;
         double heatindex = -42.379 + 2.04901523*ambientTemp + 10.14333127*hum - .22475541*ambientTemp*hum - .00683783*ambientTemp*ambientTemp - .05481717*hum*hum + .00122874*ambientTemp*ambientTemp*hum + .00085282*ambientTemp*hum*hum - .00000199*ambientTemp*ambientTemp*hum*hum;
         //double expbodytemp = (((0.238)*heatindex) + 77);
         double expbodytemp = (((slope)*heatindex) + intercept);
         System.out.println("Equation of the line: "+ slope+"+*heatindex+" + intercept+"+Range+"+range);
       if ((bodyTemp - expbodytemp) >= range) {
             sick = 1;
                if(chanceOfSick== 0)
                     {
                         chanceOfSick=1;
                     }
                     else if(chanceOfSick == 1)
                     {
                         chanceOfSick=2;
                     }
                     else if(chanceOfSick == 2)
                     {
                         chanceOfSick=3;
                     }
                     else if(chanceOfSick == 3)
                     {
                         chanceOfSick=4;
                     }
                     else if(chanceOfSick == 4)
                     {
                         chanceOfSick=4;
                     }



         }
         else{
             sick= 0;
             chanceOfSick= 0;
         }
         System.out.println("Sick-----> " + sick);
         System.out.println("chanceOfSick-------> " + chanceOfSick);
         mytestObject.put("CowID", cowID);
         mytestObject.put("BodyTemp", bodyTemp);
         mytestObject.put("AmbientTemp", ambientTemp);
         mytestObject.put("Humidity", hum);
         mytestObject.put("HeatIndex", heatindex);
         mytestObject.put("ChanceOfSick",chanceOfSick);
         mytestObject.put("Sick", sick);
         mytestObject.put("Range", range);

         if (flag == false) {
//    mytestObject.pinInBackground("MyMobileData");
       try {
             mytestObject.pin("MyMobileData");
             mytestObject.saveEventually();
             updateChanceOfSick();
             localRecordsCounter();
             System.out.println("--------------------Record Updated--------------------");
             } catch (ParseException e) {
                 e.printStackTrace();
             }
             flag = true;
             if(chanceOfSick==4){

                 Toast.makeText(mContext, "This cow is not feeling well, take immediate", Toast.LENGTH_LONG).show();


             }
             else
             {
                 Toast.makeText(mContext, "This cow is fine", Toast.LENGTH_LONG).show();
             }


         }

	return null;


  }
    private static Context mContext;
    public static void setContext(Context context)
    {
        mContext=context;
    }
    public static double celsiusToFahrenheit (double i) {

        return (9.0 / 5) * i + 32;

    }

    public static void updateAnalysis()throws ParseException {
        ParseQuery<ParseObject> equa = ParseQuery.getQuery("EquationDetails");
        equa.fromPin("equaDetails").orderByDescending("createdAt").setLimit(1);
        equa.fromLocalDatastore();
        try {
            List<ParseObject> rec = equa.find();
            sickChanceNew.addAll(rec);
            for (ParseObject sicknessnew : sickChanceNew) {
                slope=sicknessnew.getDouble("Slope");
                intercept=sicknessnew.getDouble("Intercept");
                range=sicknessnew.getDouble("Range");
                System.out.println("**************Slope**********"+slope);
                System.out.println("**************Intercept**********"+intercept);
                System.out.println("**************Range**********"+range);
            }
        } catch (ParseException e) {
            e.printStackTrace();

        }
    }
    public static void chanceOfSickness()throws ParseException {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("ChanceOfSickCounter");
        query.fromPin("counterinstance").orderByDescending("createdAt").setLimit(1);
        query.fromLocalDatastore();
      try {
            List<ParseObject> rec = query.find();
           sickChance.addAll(rec);
            for (ParseObject sickness : sickChance) {
                    chanceOfSick = (Integer) sickness.get("counter");

                }
          } catch (ParseException e) {
            e.printStackTrace();
          }
    }
   /* public static void updateChanceOfSick(int chance){
        final ParseQuery<ParseObject> chanceOfSickCounter = ParseQuery.getQuery("ChanceOfSickCounter");
        chanceOfSickCounter.orderByDescending("createdAt");
        //chanceOfSickCounter.fromLocalDatastore();

        try {
            List<ParseObject> recOne = chanceOfSickCounter.find();
            sickChanceOne.addAll(recOne);
            for (ParseObject sickness : sickChanceOne) {
                String objId = sickness.get("objectId").toString();
               // final int counter=(Integer)sickness.get("ChanceOfSick");
                System.out.println("retrieving ObjectID " + objId);
                ParseQuery<ParseObject> updatequery = ParseQuery.getQuery("ChanceOfSickCounter");
                List<ParseObject> recOne1 = updatequery.find();
                sickChanceOne1.addAll(recOne1);
                for (ParseObject sickupdate : sickChanceOne1) {
                    updatequery.put("counter", chanceOfSick);
                    try {
                        updatequery.pin("chanceOfSick");
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }

                    //updatesickcounter.pinInBackground("chanceOfSick");
                    updatequery.saveEventually();
                }
               /*updatequery.getInBackground(objId, new GetCallback<ParseObject>() {
                    public void done(ParseObject updatesickcounter, ParseException e) {
                        if (e == null) {
                            // Now let's update it with some new data. In this case, only cheatMode and score
                            // will get sent to the Parse Cloud. playerName hasn't changed.
                            updatesickcounter.put("counter", chanceOfSick);
                            try {
                                updatesickcounter.pin("chanceOfSick");
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }

                            //updatesickcounter.pinInBackground("chanceOfSick");
                            updatesickcounter.saveEventually();
                        }
                    }
                });*/
                // chanceOfSickCounter.pinInBackground("chanceOfSickness");
           /* }
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

    }*/
   public static void updateChanceOfSick(){
      ParseQuery<ParseObject> countobj = ParseQuery.getQuery("ChanceOfSickCounter");
       countobj.fromPin("counterinstance");
       countobj.fromLocalDatastore();
       try {
           List<ParseObject> chancecount = countobj.find();
           ParseObject.unpinAll("counterinstance", chancecount);
           System.out.println("*******Deleted all the counter records from the Local DataStore******");
           ParseObject chanceobject = new ParseObject("ChanceOfSickCounter");
           chanceobject.put("counter", chanceOfSick);
           chanceobject.pin("counterinstance");
           chanceobject.saveEventually();
           System.out.println("*******Updated remote files.******");


       }catch (ParseException e) {
           e.printStackTrace();
       }

   }


    public static void localRecordsCounter(){
        int count=0;
        int count1=0;
        ParseQuery<ParseObject> query1 = ParseQuery.getQuery("MyTestObject");
        query1.fromPin("MyMobileData");
        query1.fromLocalDatastore();
      try {
            List<ParseObject> rec1 = query1.find();
            count= rec1.size();
            Log.d("score", "Retrieved **************************************** " + rec1.size());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        ParseQuery<ParseObject> q= ParseQuery.getQuery("ChanceOfSickCounter");
        q.fromPin("counterinstance");
        q.fromLocalDatastore();
        try {
            List<ParseObject> rec2 = q.find();
            count1= rec2.size();
            Log.d("score", "Retrieved from chanceossickcounter **************************************** " + rec2.size());

        } catch (ParseException e) {
            e.printStackTrace();
        }
       /* query1.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList,
                             ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved ************** " + scoreList.size());
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });*/
       if(count>=4) {
          ParseQuery<ParseObject> query2 = ParseQuery.getQuery("MyTestObject");
          //query2.fromPin("MyMobileData").orderByAscending("createdAt").setLimit(3);
          query2.fromPin("MyMobileData");
          query2.fromLocalDatastore();
          try {
              List<ParseObject> cowRecords = query2.find();
//              ParseObject.unpinAllInBackground("MyMobileData", cowRecords, new DeleteCallback() {
//                  public void done(ParseException e) {
//                      // Cache the new results.
//                      System.out.println("*******Deleted all the records from the Local DataStore******");
//                      //ParseObject.pinAllInBackground(“highScores”, cowRecords);
//                  }
//              });
              ParseObject.unpinAll("MyMobileData", cowRecords);
              System.out.println("*******Deleted all the records from the Local DataStore******");

              /*query2.findInBackground(new FindCallback<ParseObject>() {
                  public void done(final List<ParseObject> cowRecords, ParseException e) {
                      // Remove the previously cached results.
                      ParseObject.unpinAllInBackground("MyMobileData", cowRecords, new DeleteCallback() {
                          public void done(ParseException e) {
                              // Cache the new results.
                              System.out.println("*******Deleted all the records from the Local DataStore******");
                              //ParseObject.pinAllInBackground(“highScores”, cowRecords);
                          }
                      });
                  }
              });*/

          }catch (ParseException e) {
              e.printStackTrace();
          }
        }
       //return count;
    }
    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
 
 public void messageAlert()
 {
     /*AlertDialog alertDialog = new AlertDialog.Builder(getActivity).create();
     alertDialog.setTitle("Status of the Cow ");
     alertDialog.setMessage("This Cow is feeling sick, Take immediate action");
     alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
         public void onClick(DialogInterface dialog, int which) {
// here you can add functions
         }
     });
     //alertDialog.setIcon(R.drawable.icon);
     alertDialog.show();*/

 }
 /* public static Sensor setHumidity(final double hum){
	 ParseQuery<ParseObject> query = ParseQuery.getQuery("TestCattleObject");
	 query.whereEqualTo("CowID","cowid");
	  query.getFirstInBackground(new GetCallback<ParseObject>() {
          public void done(ParseObject object, ParseException e) {
              if (object == null) {
                  object.put("Humidity",hum);
              } else {
                  object.put("Humidity",0);
              }
          }
      });
	 
	 
	 return null;
 }
 public void storePreferences(){
 SharedPreferences pref = ApplicationContextProvider.getContext().getApplicationContext().getSharedPreferences("MyPref", 0);
 SharedPreferences.Editor editor = pref.edit();
 editor.putString("CowID","cowid");
 editor.commit();
 
 
 
 }
 
 public void loadPreferences(){
	 
	 SharedPreferences loadPref = ApplicationContextProvider.getContext().getApplicationContext().getSharedPreferences("MyPref", 0);
	 loadPref.getString("CowID","");
	 
 }*/
 
}
   
  

