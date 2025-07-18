#pip install flask mysql-connector-python


from flask import Flask, request, jsonify
import mysql.connector

app = Flask(__name__)

# Step 1: MySQL Configuration
db = mysql.connector.connect(
    host="localhost",
    user="root",
    password="",        # <-- replace with your password
    database="testdb"   # <-- make sure this DB exists
)

cursor = db.cursor()

# Step 2: Basic route to insert data
@app.route('/add_user', methods=['POST'])
def add_user():
    data = request.get_json()
    name = data.get('name')
    email = data.get('email')

    try:
        sql = "INSERT INTO users (name, email) VALUES (%s, %s)"
        cursor.execute(sql, (name, email))
        db.commit()
        return jsonify({"message": "User added", "user_id": cursor.lastrowid}), 201
    except Exception as e:
        db.rollback()
        return jsonify({"error": str(e)}), 500

# Step 3: Run the Flask app
if __name__ == '__main__':
    app.run(debug=True)
















# pip install flask pymongo
from flask import Flask, request, jsonify
from pymongo import MongoClient

app = Flask(__name__)

# Step 1: MongoDB connection
client = MongoClient("mongodb://localhost:27017")  # Change if using Atlas
db = client["testdb"]
users_collection = db["users"]

# Step 2: Insert route
@app.route('/add_user', methods=['POST'])
def add_user():
    data = request.get_json()
    name = data.get('name')
    email = data.get('email')

    if not name or not email:
        return jsonify({"error": "Name and email required"}), 400

    try:
        result = users_collection.insert_one({"name": name, "email": email})
        return jsonify({"message": "User added", "user_id": str(result.inserted_id)}), 201
    except Exception as e:
        return jsonify({"error": str(e)}), 500

# Step 3: Run the server
if __name__ == '__main__':
    app.run(debug=True)

























-------code------------


import java.util.*;

public class Main {
    
    static int hhmm(String s) {
        String arr[] = s.split(":");
        int min = 0;
        min += Integer.parseInt(arr[0]) * 60;
        min += Integer.parseInt(arr[1]);
        return min;
    }
    
    static String mmhh(int mins) {
        String arr[] = new String[2];
        arr[0] = String.format("%02d", mins / 60);
        arr[1] = String.format("%02d", mins % 60);
        return String.join(":", arr);
    }

    public static void main(String[] args) {
        
        String[][] doctorTimes = {
            {"09:00", "13:00"},
            {"14:00", "18:00"}
        };

        String[][] patientPreferences = {
            {"09:30", "10:30"}, // Patient 0
            {"09:30", "10:30"}, // Patient 1
            {"09:30", "10:30"}, // Patient 2
            {"09:30", "10:30"}, // Patient 3
            {"10:00", "11:00"}, // Patient 4
            {"10:30", "11:00"}, // Patient 5
            {"10:45", "11:15"}, // Patient 6
            {"15:30", "16:45"}  // Patient 7
        };

        int arr[][] = new int[patientPreferences.length][2];
        boolean mp[] = new boolean[1500];

        for (String[] x : doctorTimes) {
            int start = hhmm(x[0]);
            int end = hhmm(x[1]);
            for (int i = start; i <= end; i++) {
                mp[i] = true;
            }
        }

        for (int i = 0; i < patientPreferences.length; i++) {
            arr[i][0] = hhmm(patientPreferences[i][0]);
            arr[i][1] = hhmm(patientPreferences[i][1]);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1])); // sort by end time

        StringBuilder res = new StringBuilder();

        for (int[] x : arr) {
            int s = x[0];
            int e = s + 15;
            boolean booked = false;

            while (e <= x[1]) {
                boolean free = true;
                for (int i = s; i < e; i++) {
                    if (!mp[i]) {
                        free = false;
                        break;
                    }
                }

                if (free) {
                    for (int i = s; i < e; i++) mp[i] = false;
                    res.append(mmhh(s)).append(" ").append(mmhh(e)).append("\n");
                    booked = true;
                    break;
                }

                s += 15;
                e = s + 15;
            }
        }

        System.out.println(res);
    }
}





----------code------------------


import java.util.*;
class Main {

    
    //from HHMM --> minutes
    public static int timeToMinutes(int time) {
        int hours = time / 100;
        int minutes = time % 100;
        return hours * 60 + minutes;
    }
    
    // Minutes --,> HHMM format
    public static int minutesToTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return hours * 100 + mins;
    }
    
    //display (HHMM -> HH:MM)
    public static String formatTime(int time) {
        int hours = time / 100;
        int minutes = time % 100;
        return String.format("%02d:%02d", hours, minutes);
    }
    
    public static List<List<Integer>> mergerIntervals(List<List<Integer>> in){
        Collections.sort(in,(a,b) -> a.get(0) - b.get(0));
            
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(in.get(0));
        
        for(int i=1 ;i<in.size();i++){
            List<Integer> cur = in.get(i);
            if( temp.get(1) >= cur.get(0)){
                temp.set(1,Math.max(temp.get(1),cur.get(1)));
            }else{
                res.add(temp);
                temp = new ArrayList<>(cur); 
            }
        }
        
        res.add(temp);
        
        return res;
    }
    
    public static void main(String[] args) {

        //Note ::::::: input format works for this tc don't repay on this inpt use : timeToMinutes for input  ::::::::::::
        List<List<Integer>> doctorBlockedTime = Arrays.asList(
            Arrays.asList(900, 1030),   // 09:00 - 10:30
            Arrays.asList(1200, 1300),  
            Arrays.asList(1600, 1800)   
        );
        List<Integer> doctTimeLimits = Arrays.asList(900, 2000); 
        
        List<List<Integer>> patientBlockedTime = Arrays.asList(
            Arrays.asList(1000, 1130),  
            Arrays.asList(1230, 1430), 
            Arrays.asList(1430, 1500),  
            Arrays.asList(1600, 1700)   
        );
        
        List<Integer> patientTimeLimits = Arrays.asList(1000, 1830); // 10:00 - 18:30
        
        int meetingDuration = 30;
        List<List<Integer>> dummy = new ArrayList<>();
        
        
        for(List<Integer> blo : patientBlockedTime){
            dummy.add(Arrays.asList(timeToMinutes(blo.get(0)), timeToMinutes(blo.get(1))));
        }
        for(List<Integer> blo : doctorBlockedTime){
            dummy.add(Arrays.asList(timeToMinutes(blo.get(0)), timeToMinutes(blo.get(1))));
        }
        
        List<List<Integer>> mi = mergerIntervals(dummy);
        
        
        int start = Math.max(timeToMinutes(doctTimeLimits.get(0)), timeToMinutes(patientTimeLimits.get(0)));
        int end = Math.min(timeToMinutes(doctTimeLimits.get(1)), timeToMinutes(patientTimeLimits.get(1)));
        
        List<List<Integer>> res = new ArrayList<>();
        
        
        if(mi.get(0).get(0) - start >= meetingDuration){
            res.add(List.of(start, mi.get(0).get(0)));
        }
        
        for(int i = 1; i < mi.size() ; i++){
             int dif = mi.get(i).get(0) - mi.get(i-1).get(1);
             if(dif >= meetingDuration){
                res.add(List.of(mi.get(i-1).get(1), mi.get(i).get(0)));
             }
        }
        
        
        int dif = end - mi.get(mi.size()-1).get(1);
        if(dif >= meetingDuration){
            res.add(List.of(mi.get(mi.size()-1).get(1), end));
        }
        
        
        System.out.println("Doctor's blocked times:");
        for (List<Integer> slot : doctorBlockedTime) {
            System.out.println(formatTime(slot.get(0)) + " - " + formatTime(slot.get(1)));
        }
        
        System.out.println("\nPatient's blocked times:");
        for (List<Integer> slot : patientBlockedTime) {
            System.out.println(formatTime(slot.get(0)) + " - " + formatTime(slot.get(1)));
        }
        
        System.out.println("\nDoctor available: " + formatTime(doctTimeLimits.get(0)) + 
                          " - " + formatTime(doctTimeLimits.get(1)));
        System.out.println("Patient available: " + formatTime(patientTimeLimits.get(0)) + 
                          " - " + formatTime(patientTimeLimits.get(1)));
        
        System.out.println("\nMeeting duration needed: " + meetingDuration + " minutes");
        
        System.out.println("\nMerged blocked intervals (in minutes):");
        for (List<Integer> interval : mi) {
            System.out.println(minutesToTime(interval.get(0)) + " - " + minutesToTime(interval.get(1)) + 
                             " (" + formatTime(minutesToTime(interval.get(0))) + " - " + formatTime(minutesToTime(interval.get(1))) + ")");
        }
        
        System.out.println("\nAvailable time slots for meeting:");
        if (res.isEmpty()) {
            System.out.println("No available slots found!");
        } else {
            for (List<Integer> slot : res) {
                int startTimeFormatted = minutesToTime(slot.get(0));
                int endTimeFormatted = minutesToTime(slot.get(1));
                int duration = slot.get(1) - slot.get(0);
                System.out.println(formatTime(startTimeFormatted) + " - " + 
                                 formatTime(endTimeFormatted) + " (Duration: " + duration + " minutes)");
            }
        }
    }
}

solution for gridlex quesion
