insert into usuario(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$d89uYuqozYb6ej.RmCUJP.k5WGuMufooyzRYvYW2agOJwEn1i9E3u');

insert into curso(nome, categoria) VALUES('Spring Boot', 'Programação');
insert into curso(nome, categoria) VALUES('HTML 5', 'Front-end');

insert into topico(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
insert into topico(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
insert into topico(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);
