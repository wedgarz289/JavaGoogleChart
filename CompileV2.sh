#!/usr/bin/bash

# recordar que se esta ejecutando en cygwin por lo que la forma de compilar java
# solo aplica a Windows, por lo que si se desea compilar en Linux esto cambia en
# cuestion de rutas de directorios

# funcion para obtener los jar
scan_dir_jar()
{
  dirs_jar=$1;
  separator=$2;
  var="";
  for dir in $dirs_jar; do
    if [ -d $dir ]; then
      files_jar=$(ls $dir | grep jar);
      for i in $files_jar; do
        var="$var$dir/$i$separator";
      done
    fi
  done
  echo $var;
}
# funcion para crear el manifest
make_manifest()
{
  options="$1";
  # Archivo manifest.txt
  manifest="manifest.txt";
  # fecha
  date_create=$(date);
  # vcaria para crear el contenido del manifest
  text="Manifest-Version: 1.0\n";
  # variable para crear el class path
  class_path="";
  for option in $options; do
    # echo -e "$option";
    if [[ "$option" =~ autor:.* ]]; then
      autor=$(echo "$option" | sed -rn 's/autor:(.*)/\1/p');
      echo "-- Agregando autor al archivo $manifest";
      text="${text}Created-By: ${date_create} ($autor)\n";
    elif [[ "$option" =~ programs_path:.* ]]; then
      main_path=$(echo "$option" | sed -rn 's/programs_path:(.*)/\1/p');
      package_path=$(echo "$option" | sed -rn 's/programs_path:(.*)/\1/p' | sed 's/\//./g');
      echo "-- Verificando si se tiene el archivo main.java";
      main_file=$(ls "$main_path" | grep -i "main.java");
      main_class=$(echo "${main_file}" | sed -rn 's/(.*)\.java/\1/p');
      if [ -f "${main_path}/${main_file}" ]; then
        echo "-- Existe archivo el ${main_path}/${main_file}";
        echo "-- Agregando clase principal del archivo jar"
        text="${text}Main-Class: ${package_path}.${main_class}\n";
      fi
    else
      # todo lo que entre en esta parte sera parte del class_path
      if [ -f "$option" ]; then
        echo "-- Agregando $option al class_path";
        class_path="${class_path}${option} ";
      else
        echo "-- No existe el archivo $option";
      fi
    fi
  done
  if [ -n "${class_path}" ]; then
    text="${text}Class-Path: ${class_path}\n";
  fi
  # Verificando si el archivo jar existe
  if [ -f "$manifest" ]; then
    echo "-- Actualizando el archivo $manifest";
    # borrando contenido del archivo manifest.txt
    echo "" > $manifest;
    echo -e "$text" > $manifest;
    echo "-- Contenido $manifest";
    cat "$manifest";
  else
    echo "-- Creando el archivo $manifest";
    # borrando contenido del archivo manifest.txt
    echo -e "$text" > $manifest;
    echo "-- Contenido $manifest";
    cat "$manifest";
  fi
}

################## main ##################
##### Declaracion de variables
# directorio de mis classes, programas y programas principal del jar (Main.java si se requiere)
Programs_Path="com/java/google/html/charts";
# directorios de los jar externos usados por nuestros programas
dirJars="";
# creacion de una cadena de todos los jars usados para agregarlos al class_path del archiv manifest
ALL_JAR=$(scan_dir_jar "$dirJars" " ");
# creacion del class_path para compilar nuestros programas
CP_JAR=$(scan_dir_jar "$dirJars" ";");
# echo "\"$ALL_JAR\"";
# echo "\"$CP_JAR\"";

# nombre del jar
my_jar="GoogleCharts_1_0_0.jar";
# my_jar="";
# ejecutar jar? (y/n);
# y -> yes, n -> no
# execute_jar="n";
execute_jar="y";

# estado de la Compilacion
state="n";

##########################################
# Compilando
echo "-- Compilado los archivos";
ls "$Programs_Path" | grep "\.java"
echo -e "\n--------- Compilacion ---------"
if [ -n "${ALL_JAR}" ]; then
  if javac -cp ".;$CP_JAR" "$Programs_Path/*.java"; then
    echo "- Compilado correctamente";
    state="y";
  fi
else
  if javac "$Programs_Path/*.java"; then
    echo "- Compilado correctamente";
    state="y";
  fi
fi
echo -e "-------------------------------\n";

if [ "$state" = "y" ]; then
  # ejecutando funcion para crear o actualizar el manifest.txt
  echo "-- Verificando archivo manifest.txt";
  make_manifest "autor:EDGAR programs_path:$Programs_Path $ALL_JAR";
  # creando archivo jar
  if [ -n "$my_jar" ]; then
    echo "---------- Creando el archivo ${my_jar} ----------";
    manifest=$(ls | grep "manifest\.txt");
    jar -cvfm $my_jar $manifest "${Programs_Path}/*.class";
    echo -e "-------------------------------\n";

    if [ "${execute_jar}" = "y" ]; then
      echo "---------- Ejecutando $my_jar ----------";
      java -jar $my_jar;
      echo "- Finalizando la ejecucion de $my_jar";
      echo -e "-------------------------------\n";
    else
      echo "-- No se ejecuta el archivo $my_jar de forma automatica";
      echo "-- Si desea ejecutarlo desde la terminal ingrese el comando:";
      echo -e "java -jar $my_jar\n";
    fi
  else
    echo "-- No se creo ni se ejecuto el comando jar por que la variable \$my_jar esta vacia";
  fi
fi
