SUMMARY = "A small image for a switch filtering based on Raspberry."

inherit core-image extrausers

IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_LINGUAS = " "

LICENSE = "MIT"


IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"


IMAGE_INSTALL = "packagegroup-core-boot \
${CORE_IMAGE_EXTRA_INSTALL} \
nft-custom \
ssh-keys-custom \
net-snmp-server-snmpd \
net-snmp-mibs \
"

#To avoid  systemd-networkd[149]: [[0;1;38;5;185m[[0;1;39m[[0;1;38;5;185mbr0: netdev could not be created: Operation not supported[[0m
# for bridge setup,  bridge module is required by systemd
IMAGE_INSTALL += " kernel-module-bridge "

# Add all modules related to netfilter only for ipv4
# find ./tmp/deploy/rpm/raspberrypi3_64/ \( -name "kernel-module-nf-*.rpm" -o -name "kernel-module-nfnetlink-*.rpm" \) \
#         ! -name "kernel-module*-ipv6*.rpm" -printf "%f\n"  | sed -e 's/-4.19.108.*/ \\/g'
IMAGE_INSTALL += "kernel-module-nfnetlink-log \
kernel-module-nf-conntrack-tftp \
kernel-module-nf-nat-ftp \
kernel-module-nf-nat-amanda \
kernel-module-nf-conncount \
kernel-module-nf-conntrack-snmp \
kernel-module-nf-conntrack-sip \
kernel-module-nfnetlink-acct \
kernel-module-nf-conntrack-amanda \
kernel-module-nf-conntrack-irc \
kernel-module-nf-conntrack-netbios-ns \
kernel-module-nf-nat-irc \
kernel-module-nf-conntrack-sane \
kernel-module-nf-nat-ipv4 \
kernel-module-nf-nat-proto-gre \
kernel-module-nf-conntrack-h323 \
kernel-module-nf-conntrack \
kernel-module-nfnetlink \
kernel-module-nfnetlink-osf \
kernel-module-nf-log-ipv4 \
kernel-module-nf-nat-h323 \
kernel-module-nf-reject-ipv4 \
kernel-module-nf-conntrack-proto-gre \
kernel-module-nf-nat \
kernel-module-nf-dup-ipv4 \
kernel-module-nf-nat-sip \
kernel-module-nf-conntrack-ftp \
kernel-module-nf-nat-pptp \
kernel-module-nf-conntrack-pptp \
kernel-module-nf-tproxy-ipv4 \
kernel-module-nf-socket-ipv4 \
kernel-module-nfnetlink-queue \
kernel-module-nf-nat-snmp-basic \
kernel-module-nf-defrag-ipv4 \
kernel-module-nf-conntrack-netlink \
kernel-module-nf-conntrack-broadcast \
kernel-module-nf-nat-tftp \
kernel-module-nf-log-common \
kernel-module-nf-tables \
"

IMAGE_INSTALL += " kernel-module-asix kernel-module-ax88179-178a "


ROOT_PASSWORD ?= ""

EXTRA_USERS_PARAMS = "usermod -P ${ROOT_PASSWORD} root;"


python () {
    if d.getVar('ROOT_PASSWORD') == '':
        bb.fatal(" ERROR: ROOT_PASSWORD variable is set to invalid value : \"\". Change your local.conf to put ROOT_PASSWORD=\"xxxx\".")
}
