
    create table acceptedoffer (
        id bigint generated by default as identity (start with 1),
        offerId bigint,
        userName varchar(255),
        primary key (id),
        unique (offerId, userName)
    )
;

    create table carbody (
        id bigint generated by default as identity (start with 1),
        name varchar(255),
        primary key (id)
    )
;

    create table cargooffer (
        id bigint generated by default as identity (start with 1),
        addressFrom varchar(255),
        addressTo varchar(255),
        availableFrom date,
        availableTo date,
        body varchar(255),
        cargoLength varchar(255),
        cargoLoad varchar(255),
        cargoOnPallette varchar(255),
        cargoPrice varchar(255),
        cashOnDelivery varchar(255),
        cityFrom varchar(255),
        cityTo varchar(255),
        comment varchar(255),
        contact varchar(255),
        countryFrom varchar(255),
        countryTo varchar(255),
        deliveryOnDay date,
        description varchar(255),
        dimensionOfPallettes varchar(255),
        elevator varchar(255),
        hds varchar(255),
        loadingDate date,
        negotiable varchar(255),
        numberOfPallettes bigint not null,
        offerValid date,
        otherDelivery varchar(255),
        owner varchar(255),
        partLoad varchar(255),
        postOfficeFrom varchar(255),
        postOfficeTo varchar(255),
        price varchar(255),
        readyToLoad varchar(255),
        stackablePallettes varchar(255),
        submissionDate date,
        type integer,
        unloadingDate date,
        unstackablePalettes varchar(255),
        visible boolean not null,
        volume varchar(255),
        weight varchar(255),
        primary key (id)
    )
;

    create table city (
        id bigint generated by default as identity (start with 1),
        areaCode double not null,
        city varchar(255),
        country varchar(255),
        latitude double not null,
        longitude double not null,
        metroCode double not null,
        postalCode varchar(255),
        region varchar(255),
        primary key (id)
    )
;

    create table comment (
        DTYPE varchar(31) not null,
        id bigint generated by default as identity (start with 1),
        author varchar(255) not null,
        cargoOfferId bigint,
        content varchar(255),
        date date,
        otherCommentId bigint,
        positivity integer,
        contact varchar(255),
        owner varchar(255),
        username varchar(255),
        primary key (id)
    )
;

    create table country (
        id bigint generated by default as identity (start with 1),
        iso_3166_1_alfa_2 varchar(255),
        iso_3166_1_alfa_3 varchar(255),
        iso_3166_1_digital varchar(255),
        name varchar(255),
        name_big varchar(255),
        primary key (id)
    )
;

    create table endedoffer (
        id bigint generated by default as identity (start with 1),
        offerId bigint,
        userName varchar(255),
        visible integer,
        primary key (id),
        unique (offerId, userName)
    )
;

    create table favouriteoffer (
        id bigint generated by default as identity (start with 1),
        offerId bigint,
        userName varchar(255),
        primary key (id),
        unique (offerId, userName)
    )
;

    create table offeracceptance (
        id bigint generated by default as identity (start with 1),
        initiated varchar(255),
        initiator varchar(255),
        offerId bigint,
        primary key (id),
        unique (offerId, initiator)
    )
;

    create table registrationData (
        id bigint generated by default as identity (start with 1),
        password varchar(255) not null,
        regId varchar(255) not null,
        userName varchar(255) not null,
        vCard clob,
        primary key (id)
    )
;

    create table searchcriteria (
        id bigint generated by default as identity (start with 1),
        criteriaName varchar(255),
        userName varchar(255),
        value varchar(255),
        primary key (id)
    )
;
