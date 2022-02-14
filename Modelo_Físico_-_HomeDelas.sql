CREATE DATABASE HomeDelasDB3;

USE HomeDelasDB3;

CREATE TABLE Vaga (
	idVaga INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
	linkVaga nvarchar (max) NOT NULL,
	vaga nvarchar(max) NOT NULL,
	);

select * from Vaga;

CREATE TABLE Cadastro (
	IdCadastro INT PRIMARY KEY IDENTITY (1,1) NOT NULL,
	setor nvarchar (max) NOT NULL,
	responsavel nvarchar (max) NOT NULL,
	cnpj nvarchar (max) NOT NULL,
	empresa nvarchar (max) NOT NULL,
	FkidVaga INT NOT NULL,
	);

insert into Cadastro (setor, responsavel, cnpj, empresa, FkidVaga)
values ('blabla', 'blublu', '34234234', 'Cacaou', 1)

select * from Cadastro;


alter table Cadastro add constraint FkidVaga
foreign key (FkidVaga)
references Vaga (idVaga)
on delete cascade;



SELECT v.linkVaga, v.vaga,
c.setor, c.responsavel, c.cnpj, c.empresa
FROM Vaga as v
INNER JOIN Cadastro as c on c.FkidVaga = v.linkVaga

select * from Vaga;
select * from Cadastro;


use master;
drop database HomeDelasDB3;