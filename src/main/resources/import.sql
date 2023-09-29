-- user

INSERT INTO "User" ("USER_ID", "FIRSTNAME", "LASTNAME", "USERNAME", "DOB", "EMAIL", "PHONE_NO", "COUNTRY", "SUBSCRIPTION", "REGISTRATION_DATE") VALUES (1, 'James', 'White', 'JamW','2000-04-02', 'jameswhite@email.com', '0778889211', 'UK', 'BASIC', CURRENT_DATE());
INSERT INTO "User" ("USER_ID", "FIRSTNAME", "LASTNAME", "USERNAME", "DOB", "EMAIL", "PHONE_NO", "COUNTRY", "SUBSCRIPTION", "REGISTRATION_DATE") VALUES (2, 'Julie', 'Myers', 'JulMy', '2000-02-04', 'juliemyers@email.com', '0774449211', 'UK', 'BASIC', CURRENT_DATE());
INSERT INTO "User" ("USER_ID", "FIRSTNAME", "LASTNAME", "USERNAME", "DOB", "EMAIL", "PHONE_NO", "COUNTRY", "SUBSCRIPTION", "REGISTRATION_DATE") VALUES (3, 'Bob', 'Brown', 'Bobs', '1991-04-05', 'bob@email.com', NULL, 'UK', 'BASIC', CURRENT_DATE());
INSERT INTO "User" ("USER_ID", "FIRSTNAME", "LASTNAME", "USERNAME", "DOB", "EMAIL", "PHONE_NO", "COUNTRY", "SUBSCRIPTION", "REGISTRATION_DATE") VALUES (4, 'Marco', 'Rodriguez', 'Marco123','1982-05-31', 'marcor@email.com', '0774555511', 'UK', 'PREMIUM', CURRENT_DATE());
INSERT INTO "User" ("USER_ID", "FIRSTNAME", "LASTNAME", "USERNAME", "DOB", "EMAIL", "PHONE_NO", "COUNTRY", "SUBSCRIPTION", "REGISTRATION_DATE") VALUES (5, 'Johnny', 'Kowalski', 'Kowal', '1976-06-22', 'kowal@email.com', '0774449222', 'UK', 'BASIC', CURRENT_DATE());
INSERT INTO "User" ("USER_ID", "FIRSTNAME", "LASTNAME", "USERNAME", "DOB", "EMAIL", "PHONE_NO", "COUNTRY", "SUBSCRIPTION", "REGISTRATION_DATE") VALUES (6, 'Ana-Maria', 'Bluey', 'AMBlue', '1996-07-23', 'amb@email.com', '07888449211', 'UK', 'PREMIUM', CURRENT_DATE());


-- genre
--INSERT INTO GENRE ("GENRE_ID", "GENRENAME", "DESCRIPTION") VALUES (nextval('genre_id_seq') 'Comedy', 'A good laugh')
INSERT INTO GENRE ("GENRE_ID", "GENRENAME", "DESCRIPTION") VALUES (1, 'Comedy', 'A good laugh');
INSERT INTO GENRE ("GENRE_ID", "GENRENAME", "DESCRIPTION") VALUES (2, 'Drama', NULL);
INSERT INTO GENRE ("GENRE_ID", "GENRENAME", "DESCRIPTION") VALUES (3, 'Action', NULL);
INSERT INTO GENRE ("GENRE_ID", "GENRENAME", "DESCRIPTION") VALUES (4, 'Thriller', NULL);
INSERT INTO GENRE ("GENRE_ID", "GENRENAME", "DESCRIPTION") VALUES (5, 'Family', 'For all ages');
INSERT INTO GENRE ("GENRE_ID", "GENRENAME", "DESCRIPTION") VALUES (6, 'Documentary', NULL);

--show
--INSERT INTO SHOW ("SHOW_ID", "SHOW_TITLE", "SHOW_TYPE", "SHOW_RELEASE_YEAR", "CERTIFICATE", "SHOW_SYNOPSIS", "LANGUAGE", "SHOW_DURATION", "SHOW_IMAGE", "SHOW_TRAILER", "SHOW_STREAM") VALUES (1,'The Imitation Game', 'FILM', '2014', '12A', 'During World War II, the English mathematical genius Alan Turing tries to crack the German Enigma code with help from fellow mathematicians while attempting to come to terms with his troubled private life.', 'ENGLISH', '92min', 'https://m.imdb.com/title/tt2084970/mediaviewer/rm1572681984/', 'https://www.youtube.com/embed/j2jRs4EAvWM', 'https://www.youtube.com/embed/j2jRs4EAvWM'
INSERT INTO SHOW ("SHOW_ID", "SHOW_TITLE", "SHOW_TYPE", "SHOW_RELEASE_YEAR", "CERTIFICATE", "SHOW_SYNOPSIS", "LANGUAGE", "SHOW_DURATION", "SHOW_IMAGE", "SHOW_TRAILER", "SHOW_STREAM") VALUES (1,'The Imitation Game', 'FILM', '2014', 'VALUE_4', 'During World War II, the English mathematical genius Alan Turing tries to crack the German Enigma code with help from fellow mathematicians while attempting to come to terms with his troubled private life.', 'ENGLISH', '92min', 'https://m.imdb.com/title/tt2084970/mediaviewer/rm1572681984/', 'https://www.youtube.com/embed/j2jRs4EAvWM', 'https://www.youtube.com/embed/j2jRs4EAvWM')
INSERT INTO SHOW ("SHOW_ID", "SHOW_TITLE", "SHOW_TYPE", "SHOW_RELEASE_YEAR", "CERTIFICATE", "SHOW_SYNOPSIS", "LANGUAGE", "SHOW_DURATION", "SHOW_IMAGE", "SHOW_TRAILER", "SHOW_STREAM") VALUES (2, 'The Big Bang Theory', 'SERIES', '2007-2019', 'VALUE_5', 'A woman who moves into an apartment across the hall from two brilliant but socially awkward physicists shows them how little they know about life outside of the laboratory. ', 'ENGLISH', NULL, 'https://www.imdb.com/title/tt0898266/mediaviewer/rm256251136/?ref_=tt_ov_i', 'https://youtu.be/embed/hakAG8PlBKQ', 'https://youtu.be/embed/hakAG8PlBKQ')

--episode
INSERT INTO EPISODE ("EPISODE_ID", "EPISODE_NO", "EPISODE_TITLE", "EPISODE_PLOT", "NO_OF_SEASON", "SEASON_RELEASE_YEAR", "EPISODE_DURATION", "EPISODE_IMAGE", "EPISODE_TRAILER", "EPISODE_STREAM") VALUES (2, 'S1E3', 'The Big Bran Hypothesis', 'When Sheldon and Leonard drop off a box of flat pack furniture that came for Penny, Sheldon is deeply disturbed at how messy and disorganized her apartment is.', 1, '2007', '22 min', NULL, 'https://youtu.be/embed/hakAG8PlBKQ', 'https://youtu.be/embed/hakAG8PlBKQ')

--SHOW_GENRE 
INSERT INTO SHOW_GENRE ("SHOW_ID", "GENRE_ID") VALUES (1, 2); 
INSERT INTO SHOW_GENRE ("SHOW_ID", "GENRE_ID") VALUES (1, 3); 
INSERT INTO SHOW_GENRE ("SHOW_ID", "GENRE_ID") VALUES (2, 1); 

--Payment
--INSERT INTO Payment ("PAYMENT_ID", "USER_ID", "AMOUNT", "CURRENCY") VALUES (101, '5', 99.99, 'GBP' )
INSERT INTO Payment ("PAYMENT_ID", "USER_ID", "AMOUNT", "CURRENCY", "PAYMENT_DATE") VALUES (101, 5, 99.99, 'GBP', CURRENT_DATE() )