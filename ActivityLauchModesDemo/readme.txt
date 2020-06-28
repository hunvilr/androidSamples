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

<!--
<!--        LanunchMode of All activites are standard -->
        <activity android:name=".Activity_A" android:launchMode="standard">
        <activity android:name=".Activity_B" android:launchMode="standard"/>
        <activity android:name=".Activity_C" android:launchMode="standard"/>
        <activity android:name=".Activity_D" android:launchMode="standard"/>

        Example of Activity_A -> Activity_B -> Activity_C -> Activity_B -> Back

        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_C      Number of Activities - 3
        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_B      Number of Activities - 4    Current Instance - 2
        Activity_C      Number of Activities - 3
        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Back
        Activity_C      Number of Activities - 3
        Activity_B      Number of Activities - 2    Current Instance - 1
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Back
        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Back
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity


        <activity android:name=".Activity_B" android:launchMode="standard" android:taskAffinity="com.some.new.taskAffinity" />
        <activity android:name=".Activity_C" android:launchMode="standard" android:taskAffinity="com.some.new.taskAffinity" />
        <activity android:name=".Activity_D" android:launchMode="standard" android:taskAffinity="com.some.new.taskAffinity" />
        If task affinity is added same behavior as above

        <activity android:name=".Activity_B" android:launchMode="standard" android:taskAffinity="com.some.new.taskAffinity1" />
        <activity android:name=".Activity_C" android:launchMode="standard" android:taskAffinity="com.some.new.taskAffinity2" />
        <activity android:name=".Activity_D" android:launchMode="standard" android:taskAffinity="com.some.new.taskAffinity3" />
        Even though the task affinity is different same behavior as above
-->


<!--
        <!--        LanunchMode of Activity_B is singleTop -->
        <activity android:name=".Activity_A" android:launchMode="standard">
        <activity android:name=".Activity_B" android:launchMode="singleTop"/>
        <activity android:name=".Activity_C" android:launchMode="standard"/>
        <activity android:name=".Activity_D" android:launchMode="standard"/>

        Example of Activity_A -> Activity_B -> Activity_C -> Activity_B -> Back with below launchmodes

        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_C      Number of Activities - 3
        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_B      Number of Activities - 4    Current Instance - 2
        Activity_C      Number of Activities - 3
        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Back
        Activity_C      Number of Activities - 3
        Activity_B      Number of Activities - 2    Current Instance - 1
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Back
        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Back
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        If task affinity is added same behavior as above
-->


<!--
        <!--        LanunchMode of Activity_B is singleTask -->
        <activity android:name=".Activity_A" android:launchMode="standard">
        <activity android:name=".Activity_B" android:launchMode="singleTask"/>
        <activity android:name=".Activity_C" android:launchMode="standard"/>
        <activity android:name=".Activity_D" android:launchMode="standard"/>

        Example of Activity_A -> Activity_B -> Activity_C -> Activity_B -> Activity_C -> Activity_B -> Back with below launchmodes

        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_C      Number of Activities - 3
        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_B      Number of Activities - 2    Current Instance - 1
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_C      Number of Activities - 3    Current Instance - 2
        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_B      Number of Activities - 2    Current Instance - 1
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Back
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity



        Example of Activity_A -> Activity_B -> Activity_C -> Activity_D -> Activity_B -> Back with below launchmodes

        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_C      Number of Activities - 3
        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_D      Number of Activities - 4
        Activity_C      Number of Activities - 3
        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Activity_B      Number of Activities - 2
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity

        Back
        Activity_A      Number of Activities - 1
        Stack 1
        Task1 w/o Affinity
-->



<!--

        Example of Activity_A -> Activity_B -> Activity_C -> Activity_D -> Activity_B -> Back with below launchmodes
        <activity android:name=".Activity_A" android:launchMode="standard">
        <activity android:name=".Activity_B" android:launchMode="singleTask" android:taskAffinity="com.some.new.taskAffinity" />
        <activity android:name=".Activity_C" android:launchMode="standard"/>
        <activity android:name=".Activity_D" android:launchMode="standard"/>

        STEP 1: Activity_A

        Activity_A  Number of Activities - 1
        Stack 1
        Task1 with Affinity

        STEP 2: Activity_B

        Activity_A  Number of Activities - 1       Activity_B       Number of Activities - 1
        Stack 1                                    Stack 2
        Task1 with Affinity

        STEP 3: Activity_C

                                                    Activity_C      Number of Activities - 2
        Activity_A                                  Activity_B
        Stack 1                                     Stack 2
        Task1 with Affinity

        STEP 3: Activity_D

                                                    Activity_D      Number of Activities - 3
                                                    Activity_C
        Activity_A                                  Activity_B
        Stack 1                                     Stack 2
        Task1 with Affinity

        STEP 4: Activity_B
                (POP C & D)


        Activity_A      Activity_B     Number of Activities - 1     Current Instance B - 1
        Stack 1         Stack 2
        Task1 with Affinity


        STEP 4: BACK BUTTON
              (POP B)

        Activity_A                       Activity_B
        Stack 1                          Stack 2
        Task1 with Affinity
-->

<!--
        <activity android:name=".Activity_A" android:launchMode="standard">
        <activity android:name=".Activity_B" android:launchMode="singleTask" android:taskAffinity="com.some.new.taskAffinity" />
        <activity android:name=".Activity_C" android:launchMode="singleTask" android:taskAffinity="com.some.new.taskAffinityOneMore"/>
        <activity android:name=".Activity_D" android:launchMode="standard"/>

        There will be 3 tasks created

        parent task, taskAffinity, taskAffinityOneMore
-->


<!--
        <activity android:name=".Activity_A" android:launchMode="standard">
        <activity android:name=".Activity_B" android:launchMode="singleTask" android:taskAffinity="com.some.new.taskAffinity" />
        <activity android:name=".Activity_C" android:launchMode="singleTask" android:taskAffinity="com.some.new.taskAffinity"/>
        <activity android:name=".Activity_D" android:launchMode="standard"/>

Example of Activity_A -> Activity_B -> Activity_C -> Activity_B -> Activity_D with launchmode SingleTask for B and C with same task affinity

        STEP 1: Activity_A

        Activity_A  Number of Activities - 1
        Stack 1
        Task1 with Affinity

        STEP 2: Activity_B

        Activity_A  Number of Activities - 1       Activity_B       Number of Activities - 1
        Stack 1                                    Stack 2
        Task1 with Affinity

        STEP 3: Activity_C

                                                    Activity_C      Number of Activities - 2
        Activity_A                                  Activity_B
        Stack 1                                     Stack 2
        Task1 with Affinity


        STEP 4: Activity_B

        Activity_A                                  Activity_B       Number of Activities - 1
        Stack 1                                     Stack 2
        Task1 with Affinity

        STEP 5: Activity_D

                                                    Activity_C      Number of Activities - 2
        Activity_A                                  Activity_B       Number of Activities - 1
        Stack 1                                     Stack 2
        Task1 with Affinity

-->

<!--
        <activity android:name=".Activity_A" android:launchMode="standard">
       <activity android:name=".Activity_B" android:launchMode="singleInstance" android:taskAffinity="com.some.new.taskAffinity"/>
       <activity android:name=".Activity_C" android:launchMode="standard"/>
       <activity android:name=".Activity_D" android:launchMode="standard"/>

        Example of Activity_A -> Activity_B -> Activity_C -> Activity_D ->Activity_B -> Activity_D with launchmode SingleTask with and without taskAffinity


         STEP 1: Activity_A

         Activity_A  Number of Activities - 1
         Stack 1
         Task1 with Affinity

         STEP 2: Activity_B

         Activity_A  Number of Activities - 1       Activity_B       Number of Activities - 1
         Stack 1                                    Stack 2
         Task1 with Affinity

         STEP 3: Activity_C

         Activity_C                                                             Number of Activities - 2
         Activity_A                                  Activity_B
         Stack 1                                     Stack 2
         Task1 with Affinity

         STEP 4: Activity_D

         Activity_D  Number of Activities - 3
         Activity_C  Number of Activities - 2
         Activity_A                                  Activity_B Number of Activities - 1
         Stack 1                                     Stack 2
         Task1 with Affinity


         STEP 5: Activity_B

         Activity_D  Number of Activities - 3
         Activity_C  Number of Activities - 2
         Activity_A                                  Activity_B Number of Activities - 1   current instance - 1
         Stack 1                                     Stack 2
         Task1 with Affinity

         STEP 6: Activity_D

         Activity_D  Number of Activities - 4
         Activity_D  Number of Activities - 3
         Activity_C  Number of Activities - 2
         Activity_A                                  Activity_B Number of Activities - 1   current instance - 1
         Stack 1                                     Stack 2
         Task1 with Affinity

      STEP 6: Back

      Activity_D  Number of Activities - 3
      Activity_C  Number of Activities - 2
      Activity_A                                  Activity_B Number of Activities - 1   current instance - 1
      Stack 1                                     Stack 2
      Task1 with Affinity

      STEP 7: Back

      Activity_C  Number of Activities - 2
      Activity_A                                  Activity_B Number of Activities - 1   current instance - 1
      Stack 1                                     Stack 2
      Task1 with Affinity

      STEP 8: Back

      Activity_A                                  Activity_B Number of Activities - 1   current instance - 1
      Stack 1                                     Stack 2
      Task1 with Affinity


      STEP 9: Back      goes to Activity_B but there are 2 stacks

      Activity_A                                  Activity_B Number of Activities - 1   current instance - 1
      Stack 1                                     Stack 2
      Task1 with Affinity



       <activity android:name=".Activity_A" android:launchMode="standard">
       <activity android:name=".Activity_B" android:launchMode="singleInstance" android:taskAffinity="com.some.new.taskAffinity"/>
       <activity android:name=".Activity_C" android:launchMode="singleInstance" android:taskAffinity="com.some.new.taskAffinity"/>
       <activity android:name=".Activity_D" android:launchMode="standard"/>

       there are 3 tasks formed, each single instance even though task affinity is same, a new task is created
       empty, singleInstanceB, singleInstanceC

       any activity without a task affinity will get piled over the empty task


      <activity android:name=".Activity_A" android:launchMode="standard">
      <activity android:name=".Activity_B" android:launchMode="singleInstance" android:taskAffinity="com.some.new.taskAffinity"/>
      <activity android:name=".Activity_C" android:launchMode="singleInstance" android:taskAffinity="com.some.new.taskAffinityOneMore"/>
      <activity android:name=".Activity_D" android:launchMode="standard"/>

     there are 3 tasks formed, each single instance even though task affinity is same, a new task is created
     empty, singleInstanceB, singleInstanceC

     any activity without a task affinity will get piled over the empty task
-->

    </application>

</manifest>
