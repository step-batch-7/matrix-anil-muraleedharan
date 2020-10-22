echo "Cleaning up...\n";
rm -rf out/*;

echo "Compiling files...\n";
javac -d out -classpath test:src:lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar $(find . -name "*.java");