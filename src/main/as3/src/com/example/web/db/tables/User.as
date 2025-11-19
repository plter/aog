package com.example.web.db.tables
{
    import top.yunp.aog.db.Table;

    public class User extends Table
    {

        public static const user:User = new User();

        public function User()
        {
            super("auth_user");

            integerPrimary("id");
            string("name");
            integer("age");
        }
    }
}