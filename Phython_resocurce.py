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
