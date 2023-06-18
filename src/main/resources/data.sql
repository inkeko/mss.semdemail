
---- language data
-------------------
INSERT INTO Language (language_id,name)
VALUES (1,'Hungarian'), (2,'Deutsch'),(3, 'English'),(4, 'Chinese');

----gender data
-----------------
INSERT INTO Gender(gender_id,gender)
 VALUES (1,'Male'), (2,'Female'),(3,'Other');

---- doktor data
-----------------
INSERT INTO MSS_USER (DTYPE, ACTIVE,
 EMAIL, PASSWORD, FIRST_NAME,
 LAST_NAME,GENDER,REGISTRATION_DATE,
  PHONE_NUMBER, ROLES)
 VALUES ('Doctor', 'true'
 ,'doki@gmail.com', '1151371fe13913e1f31121181f51a311819311e1721881ea', 'Csaba','Földi'
 , (SELECT gender_id FROM GENDER WHERE gender='Male'),'2022-12-25 10:15:28.145238','+36706380258','ROLE_DOCTOR');

INSERT INTO MSS_USER (DTYPE, ACTIVE,  EMAIL, PASSWORD, FIRST_NAME, LAST_NAME,
    GENDER,REGISTRATION_DATE,
     PHONE_NUMBER, ROLES)
    VALUES ('Doctor', 'true', 'dokk@gmail.com', '1151371fe13913e1f31121181f51a311819311e1721881ea', 'Zoli', 'Ozsvár',
     (SELECT gender_id FROM GENDER WHERE gender='Male'),'2023-01-02 08:15:14.587231',
     '+36306415258', 'ROLE_DOCTOR');

----client data
----------------
INSERT INTO MSS_USER (DTYPE, ACTIVE, EMAIL, PASSWORD, FIRST_NAME, LAST_NAME,
 DATE_OF_BIRTH, PLACE_OF_BIRTH, MOTHERS_NAME, TAJNUMBER, GENDER,
  PHONE_NUMBER,REGISTRATION_DATE, ROLES)
  VALUES ('Client','true', 'aleeeai@gmail.com', '1151371fe13913e1f31121181f51a311819311e1721881ea', 'Árpi', 'Balasa',
  '1970-02-18', 'Budapest', 'Pátrik Izolda', '12345118911', (SELECT gender_id FROM GENDER WHERE gender='Male'),
   '+36706389858','2023-02-20 10:10:14.254998','ROLE_CLIENT');

   INSERT INTO MSS_USER (DTYPE, ACTIVE, EMAIL, PASSWORD, FIRST_NAME, LAST_NAME,
      DATE_OF_BIRTH, PLACE_OF_BIRTH, MOTHERS_NAME, TAJNUMBER, GENDER,
       PHONE_NUMBER,REGISTRATION_DATE, ROLES)
       VALUES ('Client', 'false', 'dottk@gmail.com', '1151371fe13913e1f31121181f51a311819311e1721881ea', 'Zoli', 'Berkes',
       '1967-01-18', 'Győr', 'Andula Erika', '11881256789', (SELECT gender_id FROM GENDER WHERE gender='Female'),
         '+36306410058',CURRENT_TIMESTAMP,'ROLE_CLIENT');

--asssistant data
--------------------
INSERT INTO MSS_USER (DTYPE, ACTIVE,
 EMAIL, PASSWORD, FIRST_NAME,
  LAST_NAME,GENDER,REGISTRATION_DATE,
  PHONE_NUMBER, ROLES)
  VALUES ('Assistant', 'true'
  ,'assistant1@gmail.com', '1151371fe13913e1f31121181f51a311819311e1721881ea', 'Erika'
  , 'Vörös', (SELECT gender_id FROM GENDER WHERE gender='Female'),'2022-05-03 10:10:10.459321',
   '+36306382258','ROLE_ASSISTANT' );

----admin data
---------------
INSERT INTO MSS_USER (DTYPE, ACTIVE,
 EMAIL, PASSWORD, FIRST_NAME,
 LAST_NAME, GENDER,REGISTRATION_DATE,
  PHONE_NUMBER, ROLES)
  VALUES ('Admin', 'true'
  ,'admin111@gmail.com', '1151371fe13913e1f31121181f51a311819311e1721881ea','Góra','Gábor',
  (SELECT gender_id FROM GENDER WHERE gender='Male'),'2021-05-25 07:10:15.569823',
   '+36706110258','ROLE_ADMIN' );

-----FinancialColleague
-----------------------
INSERT INTO MSS_USER (DTYPE, ACTIVE,
 EMAIL, PASSWORD, FIRST_NAME,
 LAST_NAME, GENDER,REGISTRATION_DATE,
  PHONE_NUMBER, ROLES)
  VALUES ('FinancialColleague', 'true'
  ,'financ131@gmail.com', '1151371fe13913e1f31121181f51a311819311e1721881ea', 'Árpád', 'Gyurita',
  (SELECT gender_id FROM GENDER WHERE gender='Male'),'2021-05-25 14:15:01.458712',
  '+36306110228','ROLE_FINANCIALCOLLEAGUE' );


  --lang (user_id ,languages_id)
    -----------------------------------
   INSERT INTO mss_user_to_language (user_id ,language_id) VALUES (1,1);
   INSERT INTO mss_user_to_language (user_id ,language_id) VALUES (1,2);
   INSERT INTO mss_user_to_language (user_id ,language_id) VALUES (2,1);
   INSERT INTO mss_user_to_language (user_id ,language_id) VALUES (2,3);
   INSERT INTO mss_user_to_language (user_id ,language_id) VALUES (2,4);
   INSERT INTO mss_user_to_language (user_id ,language_id) VALUES (3,1);
   INSERT INTO mss_user_to_language (user_id ,language_id) VALUES (3,4);
   INSERT INTO mss_user_to_language (user_id ,language_id) VALUES (4,1);
   INSERT INTO mss_user_to_language (user_id ,language_id) VALUES (4,2);
   INSERT INTO mss_user_to_language (user_id ,language_id) VALUES (4,4);

-- areaOfExpertise (areaOfExpertise_id, qualification)
INSERT INTO area_of_expertise (area_of_expertise_id ,qualification) VALUES (1,'Urologist');
INSERT INTO area_of_expertise (area_of_expertise_id ,qualification) VALUES (2,'Psychologist');
INSERT INTO area_of_expertise (area_of_expertise_id ,qualification) VALUES (3,'Surgeon');
INSERT INTO area_of_expertise (area_of_expertise_id ,qualification) VALUES (4,'Dentist');
INSERT INTO area_of_expertise (area_of_expertise_id ,qualification) VALUES (5,'Gynecologist');


-- mss_user_to_areaOfExpertise( user_id,areaOfExpertise_id)
INSERT INTO mss_user_to_area_of_expertise ( user_id ,  area_of_expertise_id) VALUES (1 ,1);
INSERT INTO mss_user_to_area_of_expertise ( user_id ,  area_of_expertise_id) VALUES (1 ,3);
INSERT INTO mss_user_to_area_of_expertise ( user_id ,  area_of_expertise_id) VALUES (2 ,2);
INSERT INTO mss_user_to_area_of_expertise ( user_id ,  area_of_expertise_id) VALUES (5 ,1);
INSERT INTO mss_user_to_area_of_expertise ( user_id ,  area_of_expertise_id) VALUES (5 ,2);
