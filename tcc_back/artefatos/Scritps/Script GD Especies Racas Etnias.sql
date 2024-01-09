INSERT INTO game_data.especies (id_especie, id_capacidade, nome, descricao) 
VALUES(1,1,'Kyrath','Os Kyraths são uma espécie..... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      (2,2,'Igneray','Os Igneray são uma espécie.... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      --(3,3,'Andrano','Os Andranos são uma espécie... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      --(4,4,'Azhad','Os Azhads são uma espécie....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      (5,5,'Humano','Os Humanos são uma espécie..... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      --(6,6,'Wanari','Os Wanari são uma espécie...... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      

      (1000,1,'final','Linha final');

INSERT INTO game_data.racas (id_raca, id_especie, id_capacidade, nome, descricao)    
VALUES(1,1,21,'Yoriiz','Os Yoriiz são uma raça de Kyrath....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      --(2,1,22,'Syemenur','Os Syemenur são uma raça de Kyrath... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      
      (6,2,26,'Azerak','Os Azeraks são uma raça de Igneray.. Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      (7,2,27,'Sarok','Os Saroks são uma raça de Igneray.... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      --(8,2,28,'Ymorak','Os Ymoraks são uma raça de Igneray.... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      
      --(11,3,31,'Mukhrany','Os Mukhrany são uma raça de Andrano...... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      --(12,3,32,'Vendruhvio','Os Vendruhvio são uma raça de Andrano.. Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),

      --(16,4,36,'Morthrax','Os Morthrax são uma raça de Azhad...... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      --(17,4,37,'Vemyr','Os Vemyr são uma raça de Azhad............ Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),

      (21,5,41,'Ehleni','Os Ehleni são uma raça de Humano... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),


      (1000,1000,1,'final','Linha final');


INSERT INTO game_data.etnias (id_etnia, id_raca, id_especie, id_capacidade, nome, descricao)    
VALUES
      --- 1 a 5 Kyrath Yoriiz
      (1,1,1,null,'Avynir','Os Avynir são parte dos Kyrath Yoriiz, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),

      --- 6 a 10 Kyrath Syemenur
      --(6,2,1,null,'Yajahin','Os Yajahin são parte dos Kyrath Syemenur, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      --- 11 a 15 Kyrath ?3
      --- 16 a 20 Kyrath ?4
      --- 21 a 25 Kyrath ?5

      --- 26 a 30 Igneray Azerak
      (26,6,2,null,'Azeruth','Os Azeruth são parte dos Igneray Azerak, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      (27,6,2,null,'Iralik','Os Iralik são parte dos Igneray Azerak, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      --(28,6,2,null,'Zanaruth','Os Zanaruth são parte dos Igneray Azerak, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),

      --- 31 a 35 Igneray Saroks
      (31,7,2,null,'Tharyn','Os Tharyn são parte dos Igneray Saroks, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      (32,7,2,null,'Venazari','Os Venazari são parte dos Igneray Saroks, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),

      --- 36 a 40 Igneray Imoraks
      (36,8,2,null,'Zenrun','Os Zenrun são parte dos Igneray Imoraks, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      
      --- 41 a 45 Igneray ?3
      --- 46 a 50 Igneray ?4
      --- 51 a 55 Igneray ?5

      --- 56 a 60 Andrano Mukhrany
      --- 61 a 65 Andrano Vendruhvio
      --- 66 a 70 Andrano ?3
      --- 71 a 75 Andrano ?4
      --- 76 a 80 Andrano ?5

      --- 81 a 85 Azhad ?1
      --- 86 a 90 Azhad ?2
      --- 91 a 95 Azhad ?3
      --- 96 a 100 Azhad ?4
      --- 101 a 105 Azhad ?5

      --- 106 a 110 Humano ?1
      (106,21,5,null,'Akroy','Os Akroy são um povo dentre os Humanos Ehleni, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      (107,21,5,null,'Hendrixo','Os Hendrixo são um povo dentre os Humanos Ehleni, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),
      (108,21,5,null,'Jaremita','Os Jaremita são um povo dentre os Humanos Ehleni, um povo....... Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry,Lorem ipsum dolor sit amet fell alavalry.'),

      --- 111 a 115 Humano ?2
      --- 120 a 125 Humano ?3
      --- 106 a 110 Humano ?4
      --- 106 a 110 Humano ?5

      
      
      (1000,1000,1000,null,'final','Linha final');

