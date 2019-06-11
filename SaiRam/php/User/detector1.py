import cv2
import numpy as np



#recognizer = cv2.createLBPHFaceRecognizer()
#recognizer = cv2.face.createLBPHFaceRecognizer()
#regonizer = cv2.LBPHFaceRecognizer_create()
recognizer = cv2.face.LBPHFaceRecognizer_create()

cascadePath = "haarcascade_frontalface_default.xml"
faceCascade = cv2.CascadeClassifier(cascadePath);

recognizer.read('reco/trainner.yml')
cam = cv2.VideoCapture(0)
id=0
font = cv2.cv.InitFont(cv2.cv.CV_FONT_HERSHEY_SIMPLEX, 5,1,0,4)
while True:
    ret, img =cam.read()
    gray=cv2.cvtColor(im,cv2.COLOR_BGR2GRAY)
    faces=faceCascade.detectMultiScale(gray, 1.2,5)
    for(x,y,w,h) in faces:
        cv2.rectangle(im,(x,y),(x+w,y+h),(225,0,0),2)
        Id, conf = recognizer.predict(gray[y:y+h,x:x+w])
        if(conf<50):
            if(Id==1):
                Id="Logain"
            elif(Id==2):
                Id="Amma"
        else:
            Id="Unknown"
        cv2.cv.putText(cv2.cv.fromarray(im),str(Id), (x,y+h),font, 255)
    cv2.imshow('im',im) 
    if cv2.waitKey(10)==ord('q'):
        break
cam.release()
cv2.destroyAllWindows()
