package com.example.web.db.tables
{
    import top.yunp.aog.db.rdb.Table;
    import top.yunp.aog.db.rdb.Column;

    public class User extends Table
    {

        public static const user:User = new User();

        public var id:Column;
        public var userName:Column;
        public var age:Column;

        public function User()
        {
            super("auth_user");

            id = integerPrimary("id");
            userName = string("name");
            age = integer("age");
        }
    }
}