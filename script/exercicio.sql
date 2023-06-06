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
select cand.nome 
from candidato cand
inner join cidade cid
on cand.cidade = cid.id
and cid.qt_eleitores = 
(
select max(c.qt_eleitores)
from cidade c 
)
inner join cargo c 
on c.id = cand.cargo and c.nome = 'Prefeito'
;

--13 Selecionar a quantidade de candidatos a vereador na cidade de tubarão

select count(*) 
from candidato cand
inner join cidade cid
on cand.cidade = cid.id
and cid.nome = 'TUBARÃO'
inner join cargo c 
on c.id = cand.cargo and c.nome = 'Vereador';

--14 Selecionar a quantidade de candidatos a vereador de cada cidade, ordenado pelo nome da cidade
select cid.nome, COUNT(cand.*) 
from candidato cand
inner join cidade cid on cand.cidade = cid.id
inner join cargo c 
on c.id = cand.cargo and c.nome = 'Vereador'
group by cid.nome
order by cid.nome;

--15 Selecionar a quantidade de votos nulos e brancos para prefeito e para vereador da cidade de Tubarão.

select cid.nome, sum(vi.brancos + vi.nulos) as nulosbrancos
from voto_invalido vi 
inner join cidade cid
on vi.cidade  = cid.id
and cid.nome = 'TUBARÃO'
group by cid.nome;

--16 Selecionar a quantidade de votos INVÁLIDOS (BRANCOS + NULOS) para prefeito da cidade de Tubarão.

SELECT cid.nome, SUM(vi.brancos + vi.nulos) AS nulosbrancos
FROM voto_invalido vi
INNER JOIN cidade cid ON vi.cidade = cid.id AND cid.nome = 'TUBARÃO'
INNER JOIN cargo c ON c.id = vi.cargo AND c.nome = 'Prefeito'
GROUP BY cid.nome;

-- 17 Selecionar a quantidade de votos válidos para cada candidato a prefeito da cidade de Tubarão, ordenados pela maior quantidade de votos.

select c.nome , sum(voto.voto)
from voto
inner join candidato c on voto.candidato = c.id
INNER JOIN cidade cid ON c.cidade = cid.id AND cid.nome = 'TUBARÃO'
inner join cargo on c.cargo = cargo.id and cargo.nome = 'Prefeito'
group by c.nome
order by sum(voto.voto) desc;

-- 18 Selecionar a quantidade de votos válidos para CADA candidato a vereador da cidade de Tubarão ordenados pela maior quantidade de votos.

select c.nome , sum(voto.voto)
from voto
inner join candidato c on voto.candidato = c.id
INNER JOIN cidade cid ON c.cidade = cid.id AND cid.nome = 'TUBARÃO'
inner join cargo on c.cargo = cargo.id and cargo.nome = 'Vereador'
group by c.nome
order by sum(voto.voto) desc;

-- 19 Selecionar a maior quantidade de votos para prefeito de cada cidade.

select cid.nome , max(voto.voto)
from voto
inner join candidato c on voto.candidato = c.id
INNER JOIN cidade cid ON c.cidade = cid.id
inner join cargo on c.cargo = cargo.id and cargo.nome = 'Prefeito'
group by cid.nome;

-- 20 Selecionar os partidos e a quantidade de votos de cada um na cidade de Tubarão ordenados pela maior quantidade de votos.
