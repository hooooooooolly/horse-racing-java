-- Table: public.code_master

-- DROP TABLE IF EXISTS public.code_master;

CREATE TABLE IF NOT EXISTS public.code_master
(
    code_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    code_number integer NOT NULL,
    code_type character varying(4) COLLATE pg_catalog."default" NOT NULL,
    is_deleted boolean NOT NULL DEFAULT false,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT code_master_pkey PRIMARY KEY (code_name, code_number, code_type)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.code_master
    OWNER to postgres;

-- コード定義 --------------------------------------------------------------

insert into code_master values
('券種', 1, '単勝', default, default, default),
('券種', 2, '複勝', default, default, default),
('券種', 3, '馬単', default, default, default),
('券種', 4, '馬連', default, default, default),
('券種', 5, '三連単', default, default, default),
('券種', 6, '三連複', default, default, default),
('券種', 7, 'ワイド', default, default, default),
('券種', 8, '枠連', default, default, default),
('券種', 9, 'WIN5', default, default, default);