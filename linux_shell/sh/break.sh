rm -rf fred*
echo > fred1
echo > fred2
mkdir fred3
echo >fred4

for file in fred*
do
  echo $file
done
echo was $file
exit 0
