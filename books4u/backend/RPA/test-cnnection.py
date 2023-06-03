import mysql.connector;

conn = mysql.connector(
    host = "localhost",
    user = "root",
    password = "cocozal123",
    database = "book_hml"
)

cursor = conn.cursor()

print("test")
