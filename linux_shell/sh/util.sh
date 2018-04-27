until who | grep $1 > /dev/null
do
  sleep 60
done

echo "ok"
exit 0
