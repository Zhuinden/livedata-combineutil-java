package com.zhuinden.livedatacombineutiljava;

import org.junit.Rule;
import org.junit.Test;

import java.util.Objects;

import javax.annotation.Nullable;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicTest {
    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    static class A {
        private final String blah;

        public A() {
            this.blah = "";
        }

        public A(String blah) {
            this.blah = blah;
        }

        public String getBlah() {
            return blah;
        }


        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            A a = (A) o;
            return Objects.equals(blah, a.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        @Override
        public String toString() {
            return "A{" +
                    "blah='" + blah + '\'' +
                    '}';
        }
    }

    static class B {
        private final String blah;

        public B() {
            this.blah = "";
        }

        public B(String blah) {
            this.blah = blah;
        }

        public String getBlah() {
            return blah;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            B b = (B) o;
            return Objects.equals(blah, b.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        @Override
        public String toString() {
            return "B{" +
                    "blah='" + blah + '\'' +
                    '}';
        }
    }

    static class C {
        private final String blah;

        public C() {
            this.blah = "";
        }

        public C(String blah) {
            this.blah = blah;
        }

        public String getBlah() {
            return blah;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            C c = (C) o;
            return Objects.equals(blah, c.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        @Override
        public String toString() {
            return "C{" +
                    "blah='" + blah + '\'' +
                    '}';
        }
    }

    static class D {
        private final String blah;

        public D() {
            this.blah = "";
        }

        public D(String blah) {
            this.blah = blah;
        }

        public String getBlah() {
            return blah;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            D d = (D) o;
            return Objects.equals(blah, d.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        @Override
        public String toString() {
            return "D{" +
                    "blah='" + blah + '\'' +
                    '}';
        }
    }

    static class E {
        private final String blah;

        public E() {
            this.blah = "";
        }

        public E(String blah) {
            this.blah = blah;
        }

        public String getBlah() {
            return blah;
        }

        @Override
        public String toString() {
            return "E{" +
                    "blah='" + blah + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            E e = (E) o;
            return Objects.equals(blah, e.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }
    }

    static class F {
        private final String blah;

        public F() {
            this.blah = "";
        }

        public F(String blah) {
            this.blah = blah;
        }

        @Override
        public String toString() {
            return "F{" +
                    "blah='" + blah + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            F f = (F) o;
            return Objects.equals(blah, f.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        public String getBlah() {
            return blah;
        }
    }

    static class G {
        private final String blah;

        @Override
        public String toString() {
            return "G{" +
                    "blah='" + blah + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            G g = (G) o;
            return Objects.equals(blah, g.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        public G() {
            this.blah = "";
        }

        public G(String blah) {
            this.blah = blah;
        }

        public String getBlah() {
            return blah;
        }
    }

    static class H {
        private final String blah;

        public H() {
            this.blah = "";
        }

        public H(String blah) {
            this.blah = blah;
        }

        @Override
        public String toString() {
            return "H{" +
                    "blah='" + blah + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            H h = (H) o;
            return Objects.equals(blah, h.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        public String getBlah() {
            return blah;
        }
    }

    static class I {
        private final String blah;

        public I() {
            this.blah = "";
        }

        @Override
        public String toString() {
            return "I{" +
                    "blah='" + blah + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            I i = (I) o;
            return Objects.equals(blah, i.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        public I(String blah) {
            this.blah = blah;
        }

        public String getBlah() {
            return blah;
        }
    }

    static class J {
        private final String blah;

        public J() {
            this.blah = "";
        }

        @Override
        public String toString() {
            return "J{" +
                    "blah='" + blah + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            J j = (J) o;
            return Objects.equals(blah, j.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        public J(String blah) {
            this.blah = blah;
        }

        public String getBlah() {
            return blah;
        }
    }

    static class K {
        private final String blah;

        public K() {
            this.blah = "";
        }

        public K(String blah) {
            this.blah = blah;
        }

        @Override
        public String toString() {
            return "K{" +
                    "blah='" + blah + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            K k = (K) o;
            return Objects.equals(blah, k.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        public String getBlah() {
            return blah;
        }
    }

    static class L {
        private final String blah;

        public L() {
            this.blah = "";
        }

        @Override
        public String toString() {
            return "L{" +
                    "blah='" + blah + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            L l = (L) o;
            return Objects.equals(blah, l.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        public L(String blah) {
            this.blah = blah;
        }

        public String getBlah() {
            return blah;
        }
    }

    static class M {
        private final String blah;

        public M() {
            this.blah = "";
        }

        public M(String blah) {
            this.blah = blah;
        }

        @Override
        public String toString() {
            return "M{" +
                    "blah='" + blah + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            M m = (M) o;
            return Objects.equals(blah, m.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        public String getBlah() {
            return blah;
        }
    }

    static class N {
        private final String blah;

        public N() {
            this.blah = "";
        }

        public N(String blah) {
            this.blah = blah;
        }

        public String getBlah() {
            return blah;
        }

        @Override
        public String toString() {
            return "N{" +
                    "blah='" + blah + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            N n = (N) o;
            return Objects.equals(blah, n.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }
    }

    static class O {
        private final String blah;

        @Override
        public String toString() {
            return "O{" +
                    "blah='" + blah + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            O oo = (O)o;
            return Objects.equals(blah, oo.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        public O() {
            this.blah = "";
        }

        public O(String blah) {
            this.blah = blah;
        }

        public String getBlah() {
            return blah;
        }
    }

    static class P {
        private final String blah;

        public P() {
            this.blah = "";
        }

        public P(String blah) {
            this.blah = blah;
        }

        @Override
        public String toString() {
            return "P{" +
                    "blah='" + blah + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
            if(o == null || getClass() != o.getClass()) {
                return false;
            }
            P p = (P) o;
            return Objects.equals(blah, p.blah);
        }

        @Override
        public int hashCode() {
            return Objects.hash(blah);
        }

        public String getBlah() {
            return blah;
        }
    }

    @Test
    public void checkCombineArray16() {
        final A a1 = new A("a1");
        final A a2 = new A("a2");
        final B b1 = new B("b1");
        final B b2 = new B("b2");
        final C c1 = new C("c1");
        final C c2 = new C("c2");
        final D d1 = new D("d1");
        final D d2 = new D("d2");
        final E e1 = new E("e1");
        final E e2 = new E("e2");
        final F f1 = new F("f1");
        final F f2 = new F("f2");
        final G g1 = new G("g1");
        final G g2 = new G("g2");
        final H h1 = new H("h1");
        final H h2 = new H("h2");
        final I i1 = new I("i1");
        final I i2 = new I("i2");
        final J j1 = new J("j1");
        final J j2 = new J("j2");
        final K k1 = new K("k1");
        final K k2 = new K("k2");
        final L l1 = new L("l1");
        final L l2 = new L("l2");
        final M m1 = new M("m1");
        final M m2 = new M("m2");
        final N n1 = new N("n1");
        final N n2 = new N("n2");
        final O o1 = new O("o1");
        final O o2 = new O("o2");
        final P p1 = new P("p1");
        final P p2 = new P("p2");

        MutableLiveData<A> a = new MutableLiveData<>(a1);
        MutableLiveData<B> b = new MutableLiveData<>(b1);
        MutableLiveData<C> c = new MutableLiveData<>(c1);
        MutableLiveData<D> d = new MutableLiveData<>(d1);
        MutableLiveData<E> e = new MutableLiveData<>(e1);
        MutableLiveData<F> f = new MutableLiveData<>(f1);
        MutableLiveData<G> g = new MutableLiveData<>(g1);
        MutableLiveData<H> h = new MutableLiveData<>(h1);
        MutableLiveData<I> i = new MutableLiveData<>(i1);
        MutableLiveData<J> j = new MutableLiveData<>(j1);
        MutableLiveData<K> k = new MutableLiveData<>(k1);
        MutableLiveData<L> l = new MutableLiveData<>(l1);
        MutableLiveData<M> m = new MutableLiveData<>(m1);
        MutableLiveData<N> n = new MutableLiveData<>(n1);
        MutableLiveData<O> o = new MutableLiveData<>(o1);
        MutableLiveData<P> p = new MutableLiveData<>(p1);

        LiveData<Object[]> liveData = LiveDataCombineUtil.combineArray(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);

        final Observer<Object[]> observer = new Observer<Object[]>() {
            @Override
            public void onChanged(Object[] objects) {
            }
        };

        liveData.observeForever(observer);

        assertThat(liveData.getValue()).containsExactly(a1, b1, c1, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        a.setValue(a2);

        assertThat(liveData.getValue()).containsExactly(a2, b1, c1, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        b.setValue(b2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c1, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        c.setValue(c2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        d.setValue(d2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        e.setValue(e2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        f.setValue(f2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        g.setValue(g2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        h.setValue(h2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i1, j1, k1, l1, m1, n1, o1, p1);

        i.setValue(i2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j1, k1, l1, m1, n1, o1, p1);

        j.setValue(j2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k1, l1, m1, n1, o1, p1);

        k.setValue(k2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l1, m1, n1, o1, p1);

        l.setValue(l2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m1, n1, o1, p1);

        m.setValue(m2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n1, o1, p1);

        n.setValue(n2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n2, o1, p1);

        o.setValue(o2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n2, o2, p1);

        p.setValue(p2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n2, o2, p2);

        liveData.removeObserver(observer);
    }

    @Test
    public void checkCombine16() {
        final A a1 = new A("a1");
        final A a2 = new A("a2");
        final B b1 = new B("b1");
        final B b2 = new B("b2");
        final C c1 = new C("c1");
        final C c2 = new C("c2");
        final D d1 = new D("d1");
        final D d2 = new D("d2");
        final E e1 = new E("e1");
        final E e2 = new E("e2");
        final F f1 = new F("f1");
        final F f2 = new F("f2");
        final G g1 = new G("g1");
        final G g2 = new G("g2");
        final H h1 = new H("h1");
        final H h2 = new H("h2");
        final I i1 = new I("i1");
        final I i2 = new I("i2");
        final J j1 = new J("j1");
        final J j2 = new J("j2");
        final K k1 = new K("k1");
        final K k2 = new K("k2");
        final L l1 = new L("l1");
        final L l2 = new L("l2");
        final M m1 = new M("m1");
        final M m2 = new M("m2");
        final N n1 = new N("n1");
        final N n2 = new N("n2");
        final O o1 = new O("o1");
        final O o2 = new O("o2");
        final P p1 = new P("p1");
        final P p2 = new P("p2");

        MutableLiveData<A> a = new MutableLiveData<>(a1);
        MutableLiveData<B> b = new MutableLiveData<>(b1);
        MutableLiveData<C> c = new MutableLiveData<>(c1);
        MutableLiveData<D> d = new MutableLiveData<>(d1);
        MutableLiveData<E> e = new MutableLiveData<>(e1);
        MutableLiveData<F> f = new MutableLiveData<>(f1);
        MutableLiveData<G> g = new MutableLiveData<>(g1);
        MutableLiveData<H> h = new MutableLiveData<>(h1);
        MutableLiveData<I> i = new MutableLiveData<>(i1);
        MutableLiveData<J> j = new MutableLiveData<>(j1);
        MutableLiveData<K> k = new MutableLiveData<>(k1);
        MutableLiveData<L> l = new MutableLiveData<>(l1);
        MutableLiveData<M> m = new MutableLiveData<>(m1);
        MutableLiveData<N> n = new MutableLiveData<>(n1);
        MutableLiveData<O> o = new MutableLiveData<>(o1);
        MutableLiveData<P> p = new MutableLiveData<>(p1);

        LiveData<Object[]> liveData = LiveDataCombineUtil.combine(
                a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,
                new LiveDataCombineUtil.Combiner16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Object[]>() {
                    @Nullable
                    @Override
                    public Object[] combine(@Nullable A a, @Nullable B b, @Nullable C c, @Nullable D d, @Nullable E e, @Nullable F f, @Nullable G g, @Nullable H h, @Nullable I i, @Nullable J j, @Nullable K k, @Nullable L l, @Nullable M m, @Nullable N n, @Nullable O o, @Nullable P p) {
                        return new Object[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p};
                    }
                });

        final Observer<Object[]> observer = new Observer<Object[]>() {
            @Override
            public void onChanged(Object[] objects) {
            }
        };

        liveData.observeForever(observer);

        assertThat(liveData.getValue()).containsExactly(a1, b1, c1, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        a.setValue(a2);

        assertThat(liveData.getValue()).containsExactly(a2, b1, c1, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        b.setValue(b2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c1, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        c.setValue(c2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d1, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        d.setValue(d2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e1, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        e.setValue(e2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f1, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        f.setValue(f2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g1, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        g.setValue(g2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h1, i1, j1, k1, l1, m1, n1, o1, p1);

        h.setValue(h2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i1, j1, k1, l1, m1, n1, o1, p1);

        i.setValue(i2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j1, k1, l1, m1, n1, o1, p1);

        j.setValue(j2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k1, l1, m1, n1, o1, p1);

        k.setValue(k2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l1, m1, n1, o1, p1);

        l.setValue(l2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m1, n1, o1, p1);

        m.setValue(m2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n1, o1, p1);

        n.setValue(n2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n2, o1, p1);

        o.setValue(o2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n2, o2, p1);

        p.setValue(p2);

        assertThat(liveData.getValue()).containsExactly(a2, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2, l2, m2, n2, o2, p2);

        liveData.removeObserver(observer);
    }
}