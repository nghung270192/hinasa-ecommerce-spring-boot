CREATE TABLE IF NOT EXISTS tb_catalogue (
                                            id uuid NOT NULL CONSTRAINT tb_catalogue_pkey PRIMARY KEY,
                                            name varchar,
                                            description varchar,
                                            icon_url varchar
);
