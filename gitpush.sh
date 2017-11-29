git status
echo "*********************"
git pull origin master
git add . 
if [ -n "$1" ]; then
    git commit -m "$1"

else
    git commit -m `date +%Y%m%d`
fi
git push origin master
