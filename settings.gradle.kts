rootProject.name = "learning-framework"
include("mybatis-plus")
include("mybatis-plus:multitenant")
include("mybatis-plus:multitenant:partition")
findProject(":mybatis-plus:multitenant:partition")?.name = "partition"
include("mybatis-plus:multitenant:database")
