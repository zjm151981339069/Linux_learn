yesorno(){
  echo "is your name $*"
  while true
  do
    echo -n "Enter yes or no: "
    read x
    case "$x" in 
      y|yes) return 0;;
      n|no) return 1;;
      *) echo " Anser yes or no "
    esac
  done
}

if yesorno "mike" "nike"
then 
  echo "Hi $1, nice name"
else
  echo "Never mind"
fi
exit 0
