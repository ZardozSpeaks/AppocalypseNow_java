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
1	1656434	t
2	1657441	t
3	1657602	t
4	1657682	t
5	1657700	t
6	1657713	t
7	1657784	t
8	1657867	t
9	1657917	t
10	1658279	t
11	1658604	t
12	1658879	t
13	1659664	t
14	1659882	t
15	1660250	t
16	1660410	t
17	1661588	t
18	1661732	t
19	1661858	t
20	1661945	t
21	1662071	t
22	1662117	t
23	1662180	t
\.


--
-- Name: games_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('games_id_seq', 23, true);


--
-- Data for Name: players; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY players (id, name, image, growler, coffee_cup, dime_bag, doughnut_box, buzz, fullness, alertness, kind_bud, doughnuts, beers, coffees) FROM stdin;
18	Saul	7	f	f	f	f	11	10	10	0	10	46	0
21	Woot	6	f	f	f	f	11	4	0	0	0	35	0
8	James	9	f	f	f	f	11	0	10	0	0	4	0
9	John	3	f	f	f	f	11	10	10	0	0	0	0
10	more ladies	4	f	f	f	f	11	10	10	0	0	0	0
11	fdfds	2	f	f	f	f	11	10	10	0	0	0	0
12	ssfvcv	9	f	f	f	f	11	10	10	0	0	0	0
13	dsfdsf	4	f	f	f	f	11	10	10	0	0	0	0
14	fxdfdsfds	5	f	f	f	f	11	10	10	0	0	0	0
15	paul	7	f	f	f	f	11	10	10	0	0	0	0
16	Paul	8	f	f	f	f	11	10	10	0	0	0	0
19	Charlie	3	f	f	f	f	11	10	10	0	1	5	2
20	Saul	2	f	f	f	f	11	10	10	0	0	0	0
29	G	1	f	f	f	f	11	0	10	0	0	0	0
26	ffff	5	f	f	f	f	11	0	10	0	13	10	0
17	Paulie	1	f	f	f	f	11	10	10	0	1	77	0
23	Raul	3	f	f	f	f	11	-1	-1	0	21	7	0
24	chucvk	6	f	f	f	f	11	10	10	0	0	0	0
30	FF	2	f	f	f	f	11	0	10	0	0	0	0
22	gr	2	f	f	f	f	11	-3	-3	0	20	12	3276
27	ggg	1	f	f	f	f	11	0	10	0	0	0	0
25	dfsdf	2	f	f	f	f	11	0	8	0	8	3	0
28	ggg	2	f	f	f	f	11	0	10	0	0	0	0
\.


--
-- Name: players_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('players_id_seq', 30, true);


--
-- Data for Name: quadrants; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY quadrants (id, name) FROM stdin;
1	Providence Park
2	Park Blocks
\.


--
-- Name: quadrants_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('quadrants_id_seq', 2, true);


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

