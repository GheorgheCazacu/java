@ECHO OFF

SET parameter=""

ECHO 0. Exit
ECHO 1. set minikube to docker-env (minikube docker-env)
ECHO    you need to run the last line from output, please read the REM
ECHO 2. build both images (these means you already performed a clean build from gradle)
ECHO 3. clean minikube of services and pods
ECHO 4. create minikube services, deployments and pods
ECHO 5. get info for our exposed service
ECHO 6. add dns service to your minikube
ECHO 7. check on dns service of your minikube
ECHO 8. for minikube with driver docker, this is the option to forward the port to localhost
ECHO 9. minikube docker revert of step 1 (docker-machine env -u)
ECHO    you need to run the last line from output, please read the REM
SET /P parameter=Please enter an option:

IF %parameter% EQU "" (
    GOTO Error
)

IF %parameter% EQU 0 (
    GOTO End
)

IF %parameter% EQU 1 (
    ECHO wait...
    minikube docker-env
    GOTO End
)

IF %parameter% EQU 2 (
    REM build mysql image
    docker build -t test-mysql-docker:latest mysql-docker\src\.
    REM build web spring image
    docker build -t web-spring:latest web\.
    GOTO End
)

IF %parameter% EQU 3 (
    ECHO wait...
    kubectl delete service/mysql
    kubectl delete deployment/mysql

    kubectl delete service/spring-app-backend
    kubectl delete deployment/spring-app-backend
    GOTO End
)

IF %parameter% EQU 4 (
    kubectl create -f mysql-service.yaml
    kubectl create -f web-service.yaml
    GOTO End
)

IF %parameter% EQU 5 (
    kubectl get service/spring-app-backend
    minikube ip
    GOTO End
)

IF %parameter% EQU 6 (
    kubectl apply -f https://k8s.io/examples/admin/dns/dnsutils.yaml
    GOTO End
)

IF %parameter% EQU 7 (
    ECHO response example
    ECHO Server:    10.0.0.10
    ECHO Address 1: 10.0.0.10
    ECHO
    ECHO Name:      kubernetes.default
    ECHO Address 1: 10.0.0.1
    ECHO more details at https://kubernetes.io/docs/tasks/administer-cluster/dns-debugging-resolution/
    kubectl exec -ti dnsutils -- nslookup kubernetes.default
    GOTO End
)

IF %parameter% EQU 8 (
    minikube service spring-app-backend --url
    GOTO End
)

IF %parameter% EQU 9 (
    docker-machine env -u
    GOTO End
)

:Error
ECHO You did not enter a valid option! Bye bye!!
:End