# 프로젝트 개요

미국 배당주 투자 포트폴리오를 관리하고, 포트폴리오의 배당정보, 주가 정보를 수집하여 제공하는 서비스 입니다.
스프링부트로 개발되었으며 AWS에 배포 되어 있습니다. Client는 JSP + JQeury를 사용하였으며, 부트스트랩 4.0을 적용하여 반응형으로 개발되었습니다.

웹서버는 NGINX는 사용하고 DB는 Amazon RDS의 MariaDB를 사용하고 있습니다.

개인의 주식 포트폴리오를 관리하는데 엑셀보다는 편리한 정도를 추구하는 서비스입니다. 딱 그정도면 될것 같습니다.

# 주요기능

1. 관심 주식을 관리하고, IEX Cloud API와 Yahoo Finance 스크랩핑을 통해 가격 정보와 배당 정보를 수집하여 제공
2. 포트폴리오를 관리하고 매수목표가를 설정하고 매수가 도달 시 알림 제공
3. 포트폴리오의 수익률 및 배당 정보를 차트형태로 제공

# 개발목표

1. Spring JPA 적용
2. View는 JSP → Vue → Angular 를 차례대로 적용
3. 설계 및 개발결과를 레퍼런스로 활용할 수 있도록 정리



