export const Searchbar = () => {
  return (
    <form action="https://www.google.com/search" method="GET">
          <div>
            <input className="w-full rounded-full my-8 h-10 p-4" name="q" type="text" placeholder="Google 검색 또는 URL 입력" aria-label="Recipient's username" aria-describedby="button-addon2"/>
              <div >
            </div>
          </div>
        </form>
  )
}