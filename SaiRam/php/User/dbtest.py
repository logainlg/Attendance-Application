import mysql.connector

mydb = mysql.connector.connect(
                     host='localhost',    
                     user='root',         
                     passwd='',  
                     db='facebase')        
 
cur = mydb.cursor()
 
cur.execute('''

            INSERT INTO facebase.people (no,ID, Name)
            VALUES
            ('1','11', 'Jordan'),
            ('2','22', 'Mogran')

            ''')

mydb.commit()
