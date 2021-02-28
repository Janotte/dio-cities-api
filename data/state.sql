--
-- Table structure "state"
--

DROP TABLE IF EXISTS "state" CASCADE;

CREATE TABLE public.state (
  id bigint NOT NULL,
  name character varying(60) COLLATE pg_catalog."default",
  uf character varying(2) COLLATE pg_catalog."default",
  ibge integer,
  country_id bigint,
  ddd json,
  CONSTRAINT state_pkey PRIMARY KEY (id),
  CONSTRAINT fkghic7mqjt6qb9vq7up7awu0er FOREIGN KEY (country_id)
        REFERENCES public.country (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.state
    OWNER to postgres;

COMMENT ON TABLE state
  IS 'Federative Units';
  
--
-- Name: state_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.state_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.state_id_seq OWNER TO postgres;

--
-- Name: state_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.state_id_seq OWNED BY public.state.id;


--
-- Name: state id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.state ALTER COLUMN id SET DEFAULT nextval('public.state_id_seq'::regclass);

--
-- Inserting data into the table "state"
--

INSERT INTO "state" (id, name, uf, ibge, country_id, ddd) VALUES
(1, 'Acre', 'AC', 12, 1, '[68]'),
(2, 'Alagoas', 'AL', 27, 1, '[82]'),
(3, 'Amazonas', 'AM', 13, 1, '[97,92]'),
(4, 'Amapá', 'AP', 16, 1, '[96]'),
(5, 'Bahia', 'BA', 29, 1, '[77,75,73,74,71]'),
(6, 'Ceará', 'CE', 23, 1, '[88,85]'),
(7, 'Distrito Federal', 'DF', 53, 1, '[61]'),
(8, 'Espírito Santo', 'ES', 32, 1, '[28,27]'),
(9, 'Goiás', 'GO', 52, 1, '[62,64,61]'),
(10, 'Maranhão', 'MA', 21, 1, '[99,98]'),
(11, 'Minas Gerais', 'MG', 31, 1, '[34,37,31,33,35,38,32]'),
(12, 'Mato Grosso do Sul', 'MS', 50, 1, '[67]'),
(13, 'Mato Grosso', 'MT', 51, 1, '[65,66]'),
(14, 'Pará', 'PA', 15, 1, '[91,94,93]'),
(15, 'Paraíba', 'PB', 25, 1, '[83]'),
(16, 'Pernambuco', 'PE', 26, 1, '[81,87]'),
(17, 'Piauí', 'PI', 22, 1, '[89,86]'),
(18, 'Paraná', 'PR', 41, 1, '[43,41,42,44,45,46]'),
(19, 'Rio de Janeiro', 'RJ', 33, 1, '[24,22,21]'),
(20, 'Rio Grande do Norte', 'RN', 24, 1, '[84]'),
(21, 'Rondônia', 'RO', 11, 1, '[69]'),
(22, 'Roraima', 'RR', 14, 1, '[95]'),
(23, 'Rio Grande do Sul', 'RS', 43, 1, '[53,54,55,51]'),
(24, 'Santa Catarina', 'SC', 42, 1, '[47,48,49]'),
(25, 'Sergipe', 'SE', 28, 1, '[79]'),
(26, 'São Paulo', 'SP', 35, 1, '[11,12,13,14,15,16,17,18,19]'),
(27, 'Tocantins', 'TO', 17, 1, '[63]'),
(99, 'Exterior', 'EX', 99, NULL, NULL);

ALTER SEQUENCE state_id_seq
  RESTART 99;
