--1 Selecionar todos os registros e atributos da entidade cargo.
select * from cargo c;

--2 Selecionar a quantidade de vereadores da entidade cidade, odenado pelo nome da cidade
select c.nome, c.qt_vereadores from cidade c order by c.nome; 

--3 Selecionar e a quantidade de vereadores da entidade cidade, somente das cidades que possuem mais de 9 vereadores.
select c.nome, c.qt_vereadores from cidade c where c.qt_vereadores > 9;

--4 Selecionar quantas cidades possuem mais de 9 vereadores.
select count(*) from cidade c where c.qt_vereadores > 9;

--5 Selecionar a quantidade máxima de vereadores que uma cidade possui;
select max(qt_vereadores) from cidade c;

--6 Selecionar o nome da cidade que possui mais vereadores.
select c.nome, c.qt_vereadores  from cidade c 
where 
c.qt_vereadores =
(
select max(qt_vereadores)
from cidade c2
);

--7 Selecionar o nome dos candidatos a prefeito ordenados pelo nome
select cand.nome 
from candidato cand 
inner join cargo c on c.id = cand.cargo and c.nome = 'Prefeito' 
order by cand.nome;


--8 Selecionar o nome dos candidatos a vereador que possuem "Maria" no nome ordenados pelo nome
select cand.nome 
from candidato cand 
inner join cargo c on c.id = cand.cargo and c.nome = 'Vereador'
where cand.nome like '%MARIA %'
order by cand.nome;

--9 Selecionar o nome dos candidatos a vereador que iniciam com Y - ordenados pelo nome
select cand.nome 
from candidato cand 
inner join cargo c on c.id = cand.cargo and c.nome = 'Vereador'
where cand.nome like 'Y%'
order by cand.nome;

--10 Selecionar o nome dos candidatos a prefeito de cada cidade, ordenado pelo nome da cidade e em seguida pelo nome do candidato.
select cid.nome as cidade, cand.nome as candidato 
from candidato cand
inner join cidade cid on cand.cidade = cid.id
inner join cargo c on c.id = cand.cargo and c.nome = 'Prefeito'
order by cid.nome , cand.nome;

--11 Selecionar o nome dos candidatos a prefeito da cidade de 'TUBARÃO', ordenado pelo nome do candidato.
select cand.nome 
from candidato cand
inner join cidade cid
on cand.cidade = cid.id and cid.nome = 'TUBARÃO'
inner join cargo c 
on c.id = cand.cargo and c.nome = 'Prefeito'
order by cand.nome;

--12 Selecionar o nome dos candidatos a prefeito da cidade que tem maior número de eleitores
select
	cand.nome
from
	candidato cand
inner join cidade cid
on
	cand.cidade = cid.id
	and cid.qt_eleitores = 
(
	select
		max(c.qt_eleitores)
	from
		cidade c 
)
inner join cargo c 
on
	c.id = cand.cargo
	and c.nome = 'Prefeito'
;

--13 Selecionar a quantidade de candidatos a vereador na cidade de tubarão

select
	count(*)
from
	candidato cand
inner join cidade cid
on
	cand.cidade = cid.id
	and cid.nome = 'TUBARÃO'
inner join cargo c 
on
	c.id = cand.cargo
	and c.nome = 'Vereador';

--14 Selecionar a quantidade de candidatos a vereador de cada cidade, ordenado pelo nome da cidade
select cid.nome, COUNT(cand.*) 
from candidato cand
inner join cidade cid on cand.cidade = cid.id
inner join cargo c 
on c.id = cand.cargo and c.nome = 'Vereador'
group by cid.nome
order by cid.nome;

--15 Selecionar a quantidade de votos nulos e brancos para prefeito e para vereador da cidade de Tubarão.

select c.nome as cargo, vi.brancos, vi.nulos
from voto_invalido vi 
inner join cidade cid
on vi.cidade  = cid.id
and cid.nome = 'TUBARÃO'
inner join cargo c on vi.cargo = c.id;

--16 Selecionar a quantidade de votos INVÁLIDOS (BRANCOS + NULOS) para prefeito da cidade de Tubarão.

SELECT cid.nome, vi.brancos + vi.nulos AS nulosbrancos
FROM voto_invalido vi
INNER JOIN cidade cid ON vi.cidade = cid.id AND cid.nome = 'TUBARÃO'
INNER JOIN cargo c ON c.id = vi.cargo AND c.nome = 'Prefeito'
;

-- 17 Selecionar a quantidade de votos válidos para cada candidato a prefeito da cidade de Tubarão, ordenados pela maior quantidade de votos.

select c.nome , voto.voto as votos
from voto
inner join candidato c on voto.candidato = c.id
INNER JOIN cidade cid ON c.cidade = cid.id AND cid.nome = 'TUBARÃO'
inner join cargo on c.cargo = cargo.id and cargo.nome = 'Prefeito'
order by votos desc;

-- 18 Selecionar a quantidade de votos válidos para CADA candidato a vereador da cidade de Tubarão ordenados pela maior quantidade de votos.

select c.nome , voto.voto as votos
from voto
inner join candidato c on voto.candidato = c.id
INNER JOIN cidade cid ON c.cidade = cid.id AND cid.nome = 'TUBARÃO'
inner join cargo on c.cargo = cargo.id and cargo.nome = 'Vereador'
order by votos desc;

-- 19 Selecionar a maior quantidade de votos para prefeito de cada cidade.

select cid.nome , max(voto.voto)
from voto
inner join candidato c on voto.candidato = c.id
INNER JOIN cidade cid ON c.cidade = cid.id
inner join cargo on c.cargo = cargo.id and cargo.nome = 'Prefeito'
group by cid.nome;

-- 20 Selecionar os partidos e a quantidade de votos de cada um na cidade de Tubarão ordenados pela maior quantidade de votos.

select partido.sigla , sum(voto.voto) as votos
from partido 
inner join candidato on candidato.partido = partido.id 
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join voto on voto.candidato = candidato.id
group by partido.sigla
order by votos desc;


-- 21 Selecionar a quantidade de votos registrados para prefeito na cidade de tubarão. Os
--votos registrados são considerados os votos para os candidatos, mais os votos
--brancos e nulos.
select (((SUM(voto.voto)) + voto_invalido.brancos + voto_invalido.nulos) )
from voto
inner join candidato ON candidato.id = voto.candidato
inner join cargo ON cargo.id  = candidato.cargo and cargo.nome = 'Prefeito'
inner join cidade ON cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join voto_invalido on voto_invalido.cidade = cidade.id and voto_invalido.cargo = cargo.id
group by voto_invalido.brancos , voto_invalido.nulos;

-- 22 Selecionar a quantidade de eleitores que deixaram de votar na cidade de tubarão.
select cidade.qt_eleitores - (SUM(voto.voto + voto_invalido.brancos + voto_invalido.nulos)) AS eleitores_faltantes
from cidade
inner join candidato on cidade.id = candidato.cidade
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
left join voto on voto.candidato = candidato.id
left join voto_invalido on voto_invalido.cidade = cidade.id and voto_invalido.cargo = cargo.id
where cidade.nome = 'TUBARÃO'
group by cidade.qt_eleitores;

-- 23. Selecionar a quantidade de eleitores que deixaram de votar em cada cidade,ordenado pela maior quantidade de faltantes.

select cidade.nome, cidade.qt_eleitores - (((SUM(voto.voto)) + voto_invalido.brancos + voto_invalido.nulos) ) AS eleitores_faltantes
from cidade
inner join candidato on cidade.id = candidato.cidade
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
left join voto on voto.candidato = candidato.id
left join voto_invalido on voto_invalido.cidade = cidade.id and voto_invalido.cargo = cargo.id
group by cidade.nome, cidade.qt_eleitores, voto_invalido.brancos, voto_invalido.nulos
order by eleitores_faltantes desc;