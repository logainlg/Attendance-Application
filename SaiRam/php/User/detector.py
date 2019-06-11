import cv2
import numpy as np
import cv2 as face
from array import array


faceDetect = cv2.CascadeClassifier('haarcascade_frontalface_default.xml');
cam=cv2.VideoCapture(0);
#rec=cv2.face.LBPHFaceRecognizer_create();
#rec = cv2.face.LBPHFaceRecognizer_create()
rec=cv2.face.LBPHFaceRecognizer_create();

#rec=cv2.createLBPHFaceRecognizer();

#rec.imread("reco\trainner.yml")
rec.read("./reco/trainner.yml")


id=0
font = cv2.FONT_HERSHEY_SIMPLEX
#font = cv2.cv.InitFont(cv2.cv.CV_FONT_MERSMEY_COMPLEX_SMALL,5,1,0,4)
#font = cv2.Cv.InitFont(cv2.cv.CV_FONT_HERSHEY_SIMPLEX, 5,1,0,4)
#font=cv2.cv.InitFont(cv2.cv.CV_FONT_MERSMEY_COMPLEX_SMALL,5,1,0,4)
while(True):
    ret,img=cam.read();
    gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
    faces=faceDetect.detectMultiScale(gray,1.3,5);
    for(x,y,w,h)in faces:
        cv2.rectangle(img,(x,y),(x+w,y+h),(0,0,255),2)
        id,conf=rec.predict(gray[y:y+h,x:x+w])
        if(id==1):
            id="MS.Logaintheran"
        elif(id==2):
            id="Amma"
        elif(id==3):
            id="Gowry"
        elif(id==250632):
            id="Bala"
        else :
            "Unknown"

        #cv2.putText(cv2.from array (img), str(id),    
        #cv2.putText(cv2.fromarray(img),str(id),(x,y+h),font,255);
        #cv2.putText(cv2.cv.fromrray(img), str(id),(x,y+h),font,255);

        cv2.putText(img,str(id),(x,y+h),font,1,255);
        
        cv2.imshow("Face",img);
        if(cv2.waitKey(1)==ord('q')):
            break;

cam.release()
cv2.destroyAllWindows()
            
