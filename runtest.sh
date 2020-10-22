sh compile.sh;

echo "Running test...\n\n\n";
java -cp out:lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore $1;
