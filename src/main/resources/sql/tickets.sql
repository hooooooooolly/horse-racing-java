-- テーブル定義 ------------------------------------------------------------

-- Table: public.tickets

-- DROP TABLE IF EXISTS public.tickets;

CREATE TABLE IF NOT EXISTS public.tickets
(
    id integer NOT NULL DEFAULT nextval('tickets_seq'::regclass),
    purchase_id integer NOT NULL,
    ticket_code integer NOT NULL DEFAULT 0,
    quantity integer NOT NULL DEFAULT 0,
    hit_pair integer,
    stake integer NOT NULL DEFAULT 0,
    collection_amount integer,
    is_deleted boolean NOT NULL DEFAULT false,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT tickets_pkey PRIMARY KEY (id, purchase_id, ticket_code)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tickets
    OWNER to postgres;

-- シーケンス --------------------------------------------------------------

-- SEQUENCE: public.tickets_seq

-- DROP SEQUENCE IF EXISTS public.tickets_seq;

CREATE SEQUENCE IF NOT EXISTS public.tickets_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.tickets_seq
    OWNER TO postgres;
