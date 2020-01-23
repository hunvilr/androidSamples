<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Activity_A" android:launchMode="standard">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <!--        LanunchMode of All activites are standard -->
<!--        <activity android:name=".Activity_B" android:launchMode="standard"/>-->
<!--        <activity android:name=".Activity_C" android:launchMode="standard"/>-->
<!--        <activity android:name=".Activity_D" android:launchMode="standard"/>-->

        <!--        LanunchMode of Activity_B is singleTop -->
<!--                <activity android:name=".Activity_B" android:launchMode="singleTop"/>-->
<!--                <activity android:name=".Activity_C" android:launchMode="standard"/>-->
<!--                <activity android:name=".Activity_D" android:launchMode="standard"/>-->

        <!--        LanunchMode of Activity_B is singleTask w/o taskAffinity-->
        <!--        <activity android:name=".Activity_B" android:launchMode="singleTask"/>-->
        <!--        <activity android:name=".Activity_C" android:launchMode="standard"/>-->
        <!--        <activity android:name=".Activity_D" android:launchMode="standard"/>-->

        <!--        LanunchMode of Activity_B is singleTask with taskAffinity -->
        <!--        <activity android:name=".Activity_B" android:launchMode="singleTask" android:taskAffinity="com.some.new.taskAffinity" />-->
        <!--        <activity android:name=".Activity_C" android:launchMode="standard"/>-->
        <!--        <activity android:name=".Activity_D" android:launchMode="standard"/>-->

        <!--        LanunchMode of Activity_B and Activity_C is singleTask with taskAffinity -->
        <!--        <activity android:name=".Activity_B" android:launchMode="singleTask" android:taskAffinity="com.some.new.taskAffinity" />-->
        <!--        <activity android:name=".Activity_C" android:launchMode="singleTask" android:taskAffinity="com.some.new.taskAffinity />-->
        <!--        <activity android:name=".Activity_D" android:launchMode="standard"/>-->


                <activity android:name=".Activity_B" android:launchMode="singleInstance" android:taskAffinity="com.some.new.taskAffinity"/>
                <activity android:name=".Activity_C" android:launchMode="standard"/>
                <activity android:name=".Activity_D" android:launchMode="standard"/>

        <!--

        Example of Activity_A -> Activity_B -> Activity_C -> Activity_B -> Back with below launchmodes
        <activity android:name=".Activity_B" android:launchMode="singleTask"/>
        <activity android:name=".Activity_C" android:launchMode="standard"/>
        <activity android:name=".Activity_D" android:launchMode="standard"/>

        STEP 1: Activity_A

        Activity_A                       Activity_A
        Stack 1                          Stack 1
        Task1 w/o Affinity               Task1 with Affinity

        STEP 2: Activity_B

        Activity_B
        Activity_A                       Activity_A      Activity_B
        Stack 1                          Stack 1         Stack 2
        Task1 w/o Affinity              Task1 with Affinity

        STEP 3: Activity_C

        Activity_C
        Activity_B                                       Activity_C
        Activity_A                       Activity_A      Activity_B
        Stack 1                          Stack 1         Stack 2
        Task1 w/o Affinity              Task1 with Affinity

        STEP 4: Activity_B
                (POP C)

        Activity_B
        Activity_A                       Activity_A      Activity_B
        Stack 1                          Stack 1         Stack 2
        Task1 w/o Affinity              Task1 with Affinity


        STEP 4: BACK BUTTON
              (POP B)

        Activity_A                       Activity_A
        Stack 1                          Stack 1
        Task1 w/o Affinity              Task1 with Affinity

        Example of Activity_D -> Activity_B -> Activity_C -> Activity_B Contd from previous


        Contd STEP 1: Activity_D

        Activity_D                       Activity_D
        Activity_A                       Activity_A
        Stack 1                          Stack 1
        Task1 w/o Affinity               Task1 with Affinity

        STEP 2: Activity_B

        Activity_B
        Activity_D                       Activity_D
        Activity_A                       Activity_A      Activity_B
        Stack 1                          Stack 1         Stack 2
        Task1 w/o Affinity              Task1 with Affinity

        STEP 3: Activity_C

        Activity_C
        Activity_B
        Activity_D                       Activity_D      Activity_C
        Activity_A                       Activity_A      Activity_B
        Stack 1                          Stack 1         Stack 2
        Task1 w/o Affinity              Task1 with Affinity

        STEP 4: Activity_B
                (POP C)

        Activity_B
        Activity_D                       Activity_D
        Activity_A                       Activity_A      Activity_B
        Stack 1                          Stack 1         Stack 2
        Task1 w/o Affinity              Task1 with Affinity


        Example of Activity_A -> Activity_B -> Activity_C -> Activity_B -> Activity_D with launchmode SingleTask with and without taskAffinity

        Activity_D
        Activity_B                                                  Activity_D
        Activity_A                                  Activity_A      Activity_B
        Stack 1                                     Stack 1         Stack 2
        SingleTask Task1 w/o Affinity              SingleTask Task1 with Affinity

        Example of Activity_A -> Activity_B -> Activity_C -> Activity_B -> Activity_D with launchmode singleInstance with and without taskAffinity

        Activity_D                                                  Activity_D
        Activity_C                                                  Activity_C
        Activity_A      Activity_B                                  Activity_B      Activity_A
        Stack 1         Stack2                                      Stack 1         Stack 2
        singleInstance Task1 w/o Affinity                           singleInstance Task1 with Affinity
        visually there is only 1 task seen
        The toggle happens inside the task
        singleInstance will have the only activity in its
        task with or without taskaffinity
        -->
    </application>

</manifest>