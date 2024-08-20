class AuctionItem:
    def __init__(self, item_name, starting_bid):
        self.item_name = item_name
        self.starting_bid = starting_bid
        self.highest_bid = starting_bid
        self.highest_bidder = None
        self.bids = []

    def place_bid(self, bidder_name, bid_amount):
        if bid_amount > self.highest_bid:
            self.highest_bid = bid_amount
            self.highest_bidder = bidder_name
            self.bids.append((bidder_name, bid_amount))
            print(f"New highest bid of ${bid_amount} placed by {bidder_name}.")
        else:
            print(f"Bid of ${bid_amount} is not higher than the current highest bid of ${self.highest_bid}.")

    def close_auction(self):
        if self.highest_bidder:
            print(f"The auction for {self.item_name} is closed.")
            print(f"The winning bid is ${self.highest_bid} by {self.highest_bidder}.")
        else:
            print(f"No bids were placed on {self.item_name}. The auction is closed without a winner.")


class AuctionSystem:
    def __init__(self):
        self.items = []

    def add_item(self, item_name, starting_bid):
        new_item = AuctionItem(item_name, starting_bid)
        self.items.append(new_item)
        print(f"Auction for {item_name} started with a starting bid of ${starting_bid}.")

    def get_item(self, item_name):
        for item in self.items:
            if item.item_name == item_name:
                return item
        print(f"No auction found for {item_name}.")
        return None

    def list_items(self):
        if self.items:
            print("Current auctions:")
            for item in self.items:
                print(f"- {item.item_name} (Starting bid: ${item.starting_bid})")
        else:
            print("No items available for auction.")


def main():
    auction_system = AuctionSystem()

    while True:
        print("\nAuction System Menu:")
        print("1. Add Auction Item")
        print("2. List Auction Items")
        print("3. Place Bid")
        print("4. Close Auction")
        print("5. Exit")

        choice = input("Enter your choice (1-5): ")

        if choice == '1':
            item_name = input("Enter the item name: ")
            starting_bid = float(input("Enter the starting bid: "))
            auction_system.add_item(item_name, starting_bid)

        elif choice == '2':
            auction_system.list_items()

        elif choice == '3':
            item_name = input("Enter the name of the item you want to bid on: ")
            item = auction_system.get_item(item_name)
            if item:
                bidder_name = input("Enter your name: ")
                bid_amount = float(input("Enter your bid amount: "))
                item.place_bid(bidder_name, bid_amount)

        elif choice == '4':
            item_name = input("Enter the name of the item whose auction you want to close: ")
            item = auction_system.get_item(item_name)
            if item:
                item.close_auction()

        elif choice == '5':
            print("Exiting the auction system.")
            break

        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
