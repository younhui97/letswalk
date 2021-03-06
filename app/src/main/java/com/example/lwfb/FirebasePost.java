package com.example.lwfb;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@IgnoreExtraProperties

public class FirebasePost {

    public String id;
    public String pw;
    public String name;
    public Long age;
    public String gender;
    public int step;
    public int goal_step;
    public int height;
    public int index;
    public String year;
    public String month;
    public String day;
    public String date;
    public static List<String> friends;
    public static List<Integer> steps;
    public static List<Integer> paststeps;
    private DatabaseReference mDatabase;


    public FirebasePost() {

        // Default constructor required for calls to DataSnapshot.getValue(FirebasePost.class)

    }


    public FirebasePost(String id, String pw, String name, Long age, String gender, int step, int goal_step, int height, List<String> friends, List<Integer> steps, int index, List<Integer> paststeps) {

        this.id = id;
        this.pw = pw;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.step = step;
        this.height = height;
        this.goal_step = goal_step;
        this.friends = friends;
        this.steps = steps;
        this.paststeps = paststeps;
        this.index =index;
        this.year = year;
        this.month = month;
        this.day = day;
        this.date = date;

    }


    @Exclude

    public Map<String, Object> toMap() {

        HashMap<String, Object> result = new HashMap<>();

        result.put("id", id);
        result.put("pw", pw);
        result.put("name", name);
        result.put("age", age);
        result.put("gender", gender);
        result.put("step", step);
        result.put("goal_step", goal_step);
        result.put("height", height);
        result.put("friends", friends);
        result.put("steps", steps);
        result.put("paststeps", paststeps);
        result.put("index", index);
        result.put("year", year);
        result.put("month", month);
        result.put("day", day);
        result.put("date", date);
        return result;

    }

    public void WriteStep(String userId, int stepValue) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("MEMBER").child(userId).child("step").setValue(stepValue);
    }

    public void WriteGoal(String userId, int Goal) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("MEMBER").child(userId).child("goal_step").setValue(Goal);
    }

    public void WriteFriends(String userId, List<String> friend) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("MEMBER").child(userId).child("friends").setValue(friend);
    }

    public void WriteHeight(String userId, int Height) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("MEMBER").child(userId).child("height").setValue(Height);
    }

    public void WriteSteps(String userId) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("MEMBER").child(userId).child("steps").child(String.valueOf(PedoActivity.index)).setValue(PedoActivity.cnt);
    }
    public void WriteZeroSteps(String userId, int index, int step){

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("MEMBER").child(userId).child("steps").child(String.valueOf(index)).setValue(step);
    }

    public void WriteIndex(String userId, int index) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("MEMBER").child(userId).child("index").setValue(index);
    }
    public void WritePastSteps(String userId, String date) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("MEMBER").child(userId).child("paststeps").child(String.valueOf(date)).setValue(PedoActivity.cnt);
    }
    public void Writeregyear(String userId,int year) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("MEMBER").child(userId).child("regyear").setValue(year);
    }
    public void Writeregmonth(String userId,int month) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("MEMBER").child(userId).child("regmonth").setValue(month);
    }
}