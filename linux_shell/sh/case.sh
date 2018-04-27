echo "yes no ?"
read time

case "$time" in
  yes) echo "yes";;
  no) echo "no";;
  y) echo "y";;
  n) echo "n";;
  *) echo "any";;
esac
exit 0
