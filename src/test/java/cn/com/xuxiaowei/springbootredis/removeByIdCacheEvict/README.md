# SQL

## 逻辑删除

UPDATE
        user 
    SET
        deleted=1 
    WHERE
        id=26 
        AND deleted=0