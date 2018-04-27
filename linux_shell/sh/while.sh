echo "Enter password"
read pass
while [ "$pass" != "s" ]; do
  echo "Sorry try again"
  read pass
done
exit 0
