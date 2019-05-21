# 存在与主键相同的数据

## 主键存在，先查数据库

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
        id=24
        AND deleted=0

## 查到结果了，更新数据

    UPDATE
        user
    SET
        nickname='测试昵称18:34:43.341'
    WHERE
        id=24
        AND deleted=0

# 不存在与主键相同的数据

## 如果查到结果，插入数据（与给出的主键无关）