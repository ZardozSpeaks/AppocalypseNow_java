--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: games; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE games (
    id integer NOT NULL,
    start_time integer,
    game_running boolean
);


ALTER TABLE games OWNER TO "Guest";

--
-- Name: games_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE games_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE games_id_seq OWNER TO "Guest";

--
-- Name: games_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE games_id_seq OWNED BY games.id;


--
-- Name: players; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE players (
    id integer NOT NULL,
    name character varying,
    image integer,
    growler boolean,
    coffee_cup boolean,
    dime_bag boolean,
    doughnut_box boolean,
    buzz integer,
    fullness integer,
    alertness integer,
    kind_bud integer,
    doughnuts integer,
    beers integer,
    coffees integer
);


ALTER TABLE players OWNER TO "Guest";

--
-- Name: players_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE players_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE players_id_seq OWNER TO "Guest";

--
-- Name: players_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE players_id_seq OWNED BY players.id;


--
-- Name: quadrants; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE quadrants (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE quadrants OWNER TO "Guest";

--
-- Name: quadrants_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE quadrants_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE quadrants_id_seq OWNER TO "Guest";

--
-- Name: quadrants_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE quadrants_id_seq OWNED BY quadrants.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY games ALTER COLUMN id SET DEFAULT nextval('games_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY players ALTER COLUMN id SET DEFAULT nextval('players_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY quadrants ALTER COLUMN id SET DEFAULT nextval('quadrants_id_seq'::regclass);


--
-- Data for Name: games; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY games (id, start_time, game_running) FROM stdin;
1	1568249	t
2	1568308	t
3	1568322	t
4	1568392	t
5	1568557	t
6	1568595	t
7	1568630	t
8	1568665	t
9	1568672	t
10	1569113	t
11	1569404	t
12	1569843	t
13	1569899	t
14	3000	t
15	1457564255	t
16	1457564333	t
17	1457564551	t
18	1570724	t
19	1570895	t
20	1571342	t
21	1574256	t
22	1574499	t
23	1575260	t
24	1575310	t
25	1575353	t
26	1575454	t
27	1575517	t
28	1575577	t
29	1575751	t
30	1575782	t
31	1575808	t
32	1575835	t
33	1575855	t
34	1575886	t
35	1575915	t
36	1575962	t
37	1576059	t
38	1576109	t
\.


--
-- Name: games_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('games_id_seq', 38, true);


--
-- Data for Name: players; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY players (id, name, image, growler, coffee_cup, dime_bag, doughnut_box, buzz, fullness, alertness, kind_bud, doughnuts, beers, coffees) FROM stdin;
1	Paul	2	f	f	f	f	11	10	10	0	0	0	0
2	Paul	2	f	f	f	f	11	10	10	0	0	0	0
3	George	2	f	f	f	f	11	10	10	0	0	0	0
4	John	3	f	f	f	f	11	10	10	0	0	0	0
5	John	2	f	f	f	f	11	10	10	0	0	0	0
6	Sandy	3	f	f	f	f	11	10	10	0	0	0	0
7	Tim	3	f	f	f	f	11	10	10	0	0	0	0
28	Charles	3	f	f	f	f	11	10	10	0	0	0	0
29	Charles	3	f	f	f	f	11	10	10	0	5	6	0
30	asdf	2	f	f	f	f	11	10	10	0	0	0	0
31	Karl	3	f	f	f	f	11	10	10	0	0	0	0
32	Boo	4	f	f	f	f	11	10	10	0	0	0	0
33	gradle	1	f	f	f	f	11	10	10	0	0	0	0
34	gradle	2	f	f	f	f	11	10	10	0	0	0	0
35	gradle	1	f	f	f	f	11	10	10	0	0	0	0
36	gtgt	2	f	f	f	f	11	10	10	0	0	0	0
37	asdf	1	f	f	f	f	11	10	10	0	0	0	0
8	Willis	4	f	f	f	f	-5	-6	-6	0	0	0	0
9	Willis	3	f	f	f	f	11	10	10	0	0	0	0
10	Paul	1	f	f	f	f	11	10	10	0	0	0	0
11	Carl	2	f	f	f	f	11	10	10	0	0	0	0
12	Carl	3	f	f	f	f	11	10	10	0	0	0	0
13	tammy	4	f	f	f	f	11	10	10	0	0	0	0
14	Paula	4	f	f	f	f	11	10	10	0	0	0	0
15	Saul	1	f	f	f	f	11	10	10	0	0	0	0
16	Carl	2	f	f	f	f	11	10	10	0	0	0	0
17	Jane	4	f	f	f	f	11	10	10	0	0	0	0
18	Taylor	3	f	f	f	f	11	10	10	0	0	0	0
19	Carolyn	1	f	f	f	f	11	10	10	0	0	0	0
20	testinnnnng	2	f	f	f	f	11	10	10	0	0	0	0
21	sdfdsf	2	f	f	f	f	11	10	10	0	0	0	0
22	sdsf	2	f	f	f	f	11	10	10	0	0	0	0
23	sdfdfsd	2	f	f	f	f	11	10	10	0	0	0	0
24	ddsfdsf	1	f	f	f	f	11	10	10	0	0	0	0
25	Rufus	3	f	f	f	f	11	10	10	0	0	0	0
26	Csrl	2	f	f	f	f	11	10	10	0	0	0	0
38	t	1	f	f	f	f	11	10	10	0	0	0	0
39	asdf	1	f	f	f	f	11	10	10	0	0	0	0
40	rter	1	f	f	f	f	11	10	10	0	0	0	0
41	reerreerer	1	f	f	f	f	11	10	10	0	0	0	0
42	Pied darth pipier	3	f	f	f	f	11	10	10	0	0	0	0
43	dorkus	2	f	f	f	f	11	10	10	0	0	0	0
44	Stah	4	f	f	f	f	11	10	10	0	0	0	0
45	ereer	4	f	f	f	f	11	10	10	0	0	0	0
46	;	3	f	f	f	f	11	10	10	0	0	0	0
27	Cheryl	4	f	f	f	f	-113	-114	-114	0	0	0	0
\.


--
-- Name: players_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('players_id_seq', 46, true);


--
-- Data for Name: quadrants; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY quadrants (id, name) FROM stdin;
1	Providence Park
\.


--
-- Name: quadrants_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('quadrants_id_seq', 1, true);


--
-- Name: games_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY games
    ADD CONSTRAINT games_pkey PRIMARY KEY (id);


--
-- Name: players_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY players
    ADD CONSTRAINT players_pkey PRIMARY KEY (id);


--
-- Name: quadrants_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY quadrants
    ADD CONSTRAINT quadrants_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: epicodus
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM epicodus;
GRANT ALL ON SCHEMA public TO epicodus;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

