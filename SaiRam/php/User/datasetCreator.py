import cv2
import numpy as np
import sqlite3
import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  passwd="",
  database="facebase"
)
mycursor = mydb.cursor()

faceDetect=cv2.CascadeClassifier('haarcascade_frontalface_default.xml');
cam=cv2.VideoCapture(0);

def insertOrUpdate(Id,Name):
    ##def insert(Id,Name):
    ##conn=sqlite3.connect("FaceBase.db")
    ##cmd="SELECT * FROM People WHERE ID="+str(Id)
    ##cursor=mydb.execute(sql)
    
    
    sql="SELECT * FROM People WHERE ID="+str(Id)

    isRecordExist=0
    for row in mycursor:
        isRecordExist=1
    if(isRecordExist==1):
        sql="UPDATE People SET Name="+str(Name)+" WHERE ID="+str(Id)
    else:
        sql="INSERT INTO People(ID,Name) Values("+str(Id)+","+str(Name)+")"

    mycursor.execute(sql)

    mydb.commit()
    ##conn.execute(cmd)
    ##conn.commit()
    ##conn.close()
    print(mycursor.rowcount, "was inserted.")

Id=input('Enter User Id :')
name=input('Enter User Name :')
insertOrUpdate(Id,name)
sampleNum=0
while(True):
    ret,img=cam.read();
    gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
    faces=faceDetect.detectMultiScale(gray,1.3,5);
    for(x,y,w,h) in faces:
        sampleNum=sampleNum+1;
        cv2.imwrite("dataSet/User."+str(Id)+"."+str(sampleNum)+".jpg",gray[y:y+h,x:x+w])
        cv2.rectangle(img,(x,y),(x+w,y+h),(0,255,0),2)
        cv2.waitKey(100);
    cv2.imshow("Face",img);
    cv2.waitKey(1);
    if(sampleNum>20):
        break;
cam.release()
cv2.destroyAllWindows()
