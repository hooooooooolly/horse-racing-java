-- テーブル定義 ------------------------------------------------------------

-- Table: public.purchases

-- DROP TABLE IF EXISTS public.purchases;

CREATE TABLE IF NOT EXISTS public.purchases
(
    id integer NOT NULL DEFAULT nextval('purchases_seq'::regclass),
    purchase_date date NOT NULL,
    venue character varying(15) COLLATE pg_catalog."default" NOT NULL,
    race_no character varying(2) COLLATE pg_catalog."default" NOT NULL,
    grade character varying(10) COLLATE pg_catalog."default",
    race_name character varying(30) COLLATE pg_catalog."default",
    course character varying(3) COLLATE pg_catalog."default",
    distance integer,
    course_condition character varying(2) COLLATE pg_catalog."default",
    age character varying(4) COLLATE pg_catalog."default",
    weight character varying(3) COLLATE pg_catalog."default",
    is_deleted boolean NOT NULL DEFAULT false,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT purchases_pkey PRIMARY KEY (id, purchase_date, venue, race_no)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.purchases
    OWNER to postgres;

-- シーケンス --------------------------------------------------------------

-- SEQUENCE: public.purchases_seq

-- DROP SEQUENCE IF EXISTS public.purchases_seq;

CREATE SEQUENCE IF NOT EXISTS public.purchases_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.purchases_seq
    OWNER TO postgres;