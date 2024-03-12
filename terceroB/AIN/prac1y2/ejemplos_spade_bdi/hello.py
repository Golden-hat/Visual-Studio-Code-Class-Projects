import argparse

import asyncio

import spade

from spade_bdi.bdi import BDIAgent
# python hello.py --login yassinet --server gtirouter.dsic.upv.es

async def main():
    parser = argparse.ArgumentParser(description='spade bdi hello example')
    parser.add_argument('--login', type=str, default="basicagent", help='your UPV login.')
    parser.add_argument('--server', type=str, default="localhost", help='XMPP server address.')
    parser.add_argument('--password', type=str, default="bdipassword", help='XMPP password for the agents.')
    args = parser.parse_args()

    a = BDIAgent("HelloAgent_{}@{}".format(args.login,args.server), args.password, "hello.asl")

    await a.start()

    await asyncio.sleep(1)

    await a.stop()

if __name__ == "__main__":
        spade.run(main())