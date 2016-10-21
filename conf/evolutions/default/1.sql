# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ehr_request (
  id                            bigserial not null,
  register_date                 timestamp not null,
  status_id                     bigint,
  hec_request_id                bigint,
  constraint pk_ehr_request primary key (id)
);

create table hec_request (
  id                            bigserial not null,
  register_date                 timestamp not null,
  status_id                     bigint,
  constraint pk_hec_request primary key (id)
);

create table inference_request (
  id                            bigserial not null,
  register_date                 timestamp not null,
  status_id                     bigint,
  hec_request_id                bigint,
  constraint pk_inference_request primary key (id)
);

create table request_status (
  id                            bigserial not null,
  description                   varchar(255) not null,
  constraint pk_request_status primary key (id)
);

create table triage_request (
  id                            bigserial not null,
  register_date                 timestamp not null,
  status_id                     bigint,
  hec_request_id                bigint,
  constraint pk_triage_request primary key (id)
);

alter table ehr_request add constraint fk_ehr_request_status_id foreign key (status_id) references request_status (id) on delete restrict on update restrict;
create index ix_ehr_request_status_id on ehr_request (status_id);

alter table ehr_request add constraint fk_ehr_request_hec_request_id foreign key (hec_request_id) references hec_request (id) on delete restrict on update restrict;
create index ix_ehr_request_hec_request_id on ehr_request (hec_request_id);

alter table hec_request add constraint fk_hec_request_status_id foreign key (status_id) references request_status (id) on delete restrict on update restrict;
create index ix_hec_request_status_id on hec_request (status_id);

alter table inference_request add constraint fk_inference_request_status_id foreign key (status_id) references request_status (id) on delete restrict on update restrict;
create index ix_inference_request_status_id on inference_request (status_id);

alter table inference_request add constraint fk_inference_request_hec_request_id foreign key (hec_request_id) references hec_request (id) on delete restrict on update restrict;
create index ix_inference_request_hec_request_id on inference_request (hec_request_id);

alter table triage_request add constraint fk_triage_request_status_id foreign key (status_id) references request_status (id) on delete restrict on update restrict;
create index ix_triage_request_status_id on triage_request (status_id);

alter table triage_request add constraint fk_triage_request_hec_request_id foreign key (hec_request_id) references hec_request (id) on delete restrict on update restrict;
create index ix_triage_request_hec_request_id on triage_request (hec_request_id);


# --- !Downs

alter table if exists ehr_request drop constraint if exists fk_ehr_request_status_id;
drop index if exists ix_ehr_request_status_id;

alter table if exists ehr_request drop constraint if exists fk_ehr_request_hec_request_id;
drop index if exists ix_ehr_request_hec_request_id;

alter table if exists hec_request drop constraint if exists fk_hec_request_status_id;
drop index if exists ix_hec_request_status_id;

alter table if exists inference_request drop constraint if exists fk_inference_request_status_id;
drop index if exists ix_inference_request_status_id;

alter table if exists inference_request drop constraint if exists fk_inference_request_hec_request_id;
drop index if exists ix_inference_request_hec_request_id;

alter table if exists triage_request drop constraint if exists fk_triage_request_status_id;
drop index if exists ix_triage_request_status_id;

alter table if exists triage_request drop constraint if exists fk_triage_request_hec_request_id;
drop index if exists ix_triage_request_hec_request_id;

drop table if exists ehr_request cascade;

drop table if exists hec_request cascade;

drop table if exists inference_request cascade;

drop table if exists request_status cascade;

drop table if exists triage_request cascade;

