# SQL

    SELECT
        id,
        username,
        nickname,
        password,
        age,
        create_date,
        update_date,
        deleted,
        remarks 
    FROM
        user 
    WHERE
        id=20 
        AND deleted=0