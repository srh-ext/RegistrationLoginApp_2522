--
-- Daten für Tabelle `tbl_user`
--

INSERT INTO `tbl_user` (`user_id`, `gender`, `first_name`, `last_name`, `birthdate`, `email`, `hash_password`, `creation_date`) VALUES
(1, 'MR', 'Yuriy', 'Beck', '1986-11-13', 'social@solovyov.de', '098f6bcd4621d373cade4e832627b4f6', '2023-11-17 08:32:55');

SELECT * FROM tbl_user WHERE email LIKE 'social@solovyov.de';
SELECT * FROM tbl_user WHERE hash_password LIKE MD5('test');