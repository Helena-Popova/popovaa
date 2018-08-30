CREATE TABLE company
(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer references company(id),
CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company (id,name) values (1,'c_one'),
(2,'c_two'),
(3,'c_three'),
(4,'c_four'),
(5,'c_five');

insert into person (id,name,company_id) values (1,'Jon', 5),
(2,'Maty', 5),
(3,'Mary', 2),
(4,'Silver', 3),
(5,'Dan', 1);
/**
// 1) Retrieve in a single query:
// - names of all persons that are NOT in the company with id = 5
// - company name for each person
 */
select p.name, c.name from company as c left outer  join person as p on p.company_id = c.id
where c.id != 5 and p.name is not null;

/**
2) Select the name of the company with the maximum number of persons + number of persons in this company
 */
create view persons_in_company as
select count(person.company_id) as p, company.name from person
inner join company on (person.company_id = company.id)
group by company.name ;

select p,name from persons_in_company where p = (select max(p) from persons_in_company);