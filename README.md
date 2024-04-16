# ⏱ ChronoMeter
- A simple efficient stopwatch timer Android application built using Java. 
- This app provides precise timing functionalities and a user-friendly interface for tracking time durations accurately.

## ✨ Glipmse of Application:
<img src="https://github.com/Nayak-Sahil/ChronoMeter/blob/main/App_Demo.jpg" alt="DiffiHellmen Process" width="300" style="transform: rotate(-90deg);">

## 👩‍💻 How to use ChronoMeter in Android?
 **Add Chronometer to Layout**: Include the Chronometer widget in your layout XML file.
   ```xml
   <Chronometer
       android:id="@+id/chronometer"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:format="HH:mm:ss"
       android:textSize="48sp" />
  ```
**How to operate Chronometer by programmatically?**

**Initialize Chronometer**
```java
Chronometer chrnMeter = findViewById(R.id.chronometer);
```

**Start/Resume Chronometer**
```java
chrnMeter.start();
```

**Pause Chronometer**
```java
chrnMeter.stop();
```

**Reset Chronometer to 00:00**
```java
chrnMeter.setBase(SystemClock.elapsedRealtime());
// after reset value to 00:00 above setBase() restart the timer not just reset. so it's important to stop after resetting value.
chrnMeter.stop();
```
