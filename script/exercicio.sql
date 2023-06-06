-- Selecionar todos os registros e atributos da entidade cargo.
select * from cargo c;

-- Selecionar a quantidade de vereadores da entidade cidade, odenado pelo nome da cidade
select c.nome, c.qt_vereadores from cidade c order by c.nome; 

-- Selecionar e a quantidade de vereadores da entidade cidade, somente das cidades que possuem mais de 9 vereadores.
select c.nome, c.qt_vereadores from cidade c where c.qt_vereadores > 9;

-- Selecionar quantas cidades possuem mais de 9 vereadores.
select count(*) from cidade c where c.qt_vereadores > 9;

-- Selecionar a quantidade máxima de vereadores que uma cidade possui;
select max(qt_vereadores) from cidade c;

-- Selecionar o nome da cidade que possui mais vereadores.
select c.nome, c.qt_vereadores  from cidade c 
where 
c.qt_vereadores =
(
select max(qt_vereadores)
from cidade c2
);

-- Selecionar o nome dos candidatos a prefeito ordenados pelo nome
select cand.nome from candidato cand where cand.cargo = 1 order by cand.nome;


-- Selecionar o nome dos candidatos a vereador que possuem "Maria" no nome ordenados pelo nome
select cand.nome 
from candidato cand 
where cand.nome like '%MARIA %'
and cand.partido = 2
order by cand.nome;

-- Selecionar o nome dos candidatos a vereador que iniciam com Y - ordenados pelo nome
select cand.nome 
from candidato cand 
where cand.nome like 'Y%'
and cand.partido = 2
order by cand.nome;

-- Selecionar o nome dos candidatos a prefeito de cada cidade, ordenado pelo nome da cidade e em seguida pelo nome do candidato.
select cid.nome, cand.nome 
from candidato cand
inner join cidade cid
on cand.cidade = cid.id
and cand.cargo = 1
order by cid.nome , cand.nome;

-- Selecionar o nome dos candidatos a prefeito da cidade de 'TUBARÃO', ordenado pelo nome do candidato.
select cand.nome 
from candidato cand
inner join cidade cid
on cand.cidade = cid.id
and cand.cargo = 1
and cid.nome = 'TUBARÃO'
order by cand.nome;

-- Selecionar o nome dos candidatos a prefeito da cidade que tem maior número de eleitores
select cand.nome 
from candidato cand
inner join cidade cid
on cand.cidade = cid.id
and cand.cargo = 1
and cid.qt_eleitores = 
(
select max(c.qt_eleitores)
from cidade c 
);

-- Selecionar a quantidade de candidatos a vereador na cidade de tubarão

select count(*) 
from candidato cand
inner join cidade cid
on cand.cidade = cid.id
and cand.cargo = 2
and cid.nome = 'TUBARÃO';

-- Selecionar a quantidade de candidatos a vereador de cada cidade, ordenado pelo nome da cidade
select cid.nome, COUNT(cand.*) 
from candidato cand
inner join cidade cid on cand.cidade = cid.id
group by cid.nome
order by cid.nome;

-- Selecionar a quantidade de votos nulos e brancos para prefeito e para vereador da cidade de Tubarão.

select cid.nome, count(vi.brancos + vi.nulos)
from voto_invalido vi 
inner join cidade cid
on vi.cidade  = cid.id
and cid.nome = 'TUBARÃO'
group by cid.nome;

-- Selecionar a quantidade de votos INVÁLIDOS (BRANCOS + NULOS) para prefeito da cidade de Tubarão.

select cid.nome, count(vi.brancos + vi.nulos)
from voto_invalido vi 
inner join cidade cid
on vi.cidade  = cid.id
and cid.nome = 'TUBARÃO'
inner join candidato c
on c.cidade = cid.id 
and c.cargo = 1
group by cid.nome;